package ca.gbc.comp3074.mind_manager_app;

import android.os.StrictMode;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import ca.gbc.comp3074.mind_manager_app.Models.Answer;
import ca.gbc.comp3074.mind_manager_app.Models.Question;
import ca.gbc.comp3074.mind_manager_app.Models.Suggestion;
import ca.gbc.comp3074.mind_manager_app.Models.User;

public class GoogleMySQLConnectionHelper {

    String username, password, ip, port, database;
    Connection connection = null;

    // make connection with MySQL instance
    public Connection connectionclass(){
        ip = "mind-manager-do-user-8581613-0.b.db.ondigitalocean.com";
        port = "25060";
        database = "mindmanager";
        username = "doadmin";
        password = "bys508oal0qpna4x";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://mind-manager-do-user-8581613-0.b.db.ondigitalocean.com:25060/mindmanager?characterEncoding=utf8", username, password);
        }
        catch (Exception exception){
            Log.e("Error: ", exception.getMessage());
        }

        return connection;
    }

    // get a suggestion by mood and category
    public Suggestion getSuggestion(Connection connect, String mood, String category) {
        Suggestion suggestionExist = null;
        try {
            if (connect != null) {
                String query = "SELECT * FROM suggestions WHERE mood IN ('" + mood + "') AND " +
                        "category_name IN ('" + category + "') ORDER BY RAND() LIMIT 1";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    suggestionExist = new Suggestion(rs.getInt(1),rs.getString(2),
                            rs.getString(3), rs.getString(4) , rs.getString(5));
                }
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
        return suggestionExist;
    }

    // code to get all users in a list view
    public ArrayList<Suggestion> getAllCategories(Connection connect) {
        ArrayList<Suggestion> categories = new ArrayList<>();
        try {
            if (connect != null) {
                String query = "SELECT DISTINCT category_name FROM suggestions";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    categories.add(new Suggestion(rs.getString(1)));
                }
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
        return categories;
    }

    //get the random question
    public Question getRandomQuestion(Connection connect) {
        Question randomQuestion = null;
        try {
            if (connect != null) {
                String query = "SELECT * FROM questions ORDER BY RAND() LIMIT 1";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    ArrayList<Answer> answers = getAnswers(connect, rs.getInt(1));
                    randomQuestion = new Question(rs.getInt(1),rs.getString(2), answers);
                }
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
        return randomQuestion;
    }

    //get the question by ID
    public Question getQuestionByID(Connection connect, int id) {
        Question question = null;
        try {
            if (connect != null) {
                String query = "SELECT * FROM questions WHERE id = " + id;
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    ArrayList<Answer> answers = getAnswers(connect, rs.getInt(1));
                    question = new Question(rs.getInt(1),rs.getString(2), answers);
                }
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
        return question;
    }

    //get the question by ID
    public Question getQuestionByText(Connection connect, String text) {
        Question question = null;
        try {
            if (connect != null) {
                String query = "SELECT * FROM questions WHERE question_text = '" + text + "'";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    ArrayList<Answer> answers = getAnswers(connect, rs.getInt(1));
                    question = new Question(rs.getInt(1),rs.getString(2), answers);
                }
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
        return question;
    }

    // code to get all users in a list view
    public ArrayList<Question> getAllQuestions(Connection connect) {
        ArrayList<Question> questions = new ArrayList<>();
        try {
            if (connect != null) {
                String query = "SELECT  * FROM questions";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    questions.add(new Question(rs.getInt(1), rs.getString(2)));
                }
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
        return questions;
    }

    // add the new question
    public void addQuestion(Connection connect, Question question)  {
        try {
            if (connect != null) {
                String query = "INSERT INTO questions (question_text) " +
                        "VALUES ('" + question.getQuestionText() + "')";
                Statement st = connect.createStatement();
                st.executeUpdate(query);
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
    }

    // Deleting single question
    public void deleteQuestion(Connection connect, int questionID) {
        try {
            if (connect != null) {
                String query1 = "DELETE FROM answers WHERE question_id = " + questionID;
                String query2 = "DELETE FROM questions WHERE id = " + questionID;
                Statement st = connect.createStatement();
                st.executeUpdate(query1);
                st.executeUpdate(query2);
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
    }

    //get answers for question by questionId
    public ArrayList<Answer> getAnswers(Connection connect, int questionId) {
        ArrayList<Answer> answers = new ArrayList<>();
        try {
            if (connect != null) {
                String query = "SELECT * FROM answers WHERE question_id = " + questionId;
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    answers.add(new Answer(rs.getInt(1), rs.getInt(2),
                            rs.getString(3), rs.getInt(4), rs.getInt(5),
                            rs.getInt(6), rs.getInt(7), rs.getInt(8)));
                }
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
        return answers;
    }

    // add the new question
    public void addAnswer(Connection connect, Answer answer)  {
        try {
            if (connect != null) {
                String query = "INSERT INTO answers (question_id, answer_text, bored_rating, " +
                        "energetic_rating, happy_rating, sad_rating, tired_rating) " +
                        "VALUES ('" + answer.getQuestion_id() + "', '" + answer.getText() + "', '"
                        + answer.getBoredRating() + "', '" + answer.getEnergeticRating() +
                        "', '" + answer.getHappyRating() + "', '" + answer.getSadRating() +
                        "', '" + answer.getTiredRating() + "')";
                Statement st = connect.createStatement();
                st.executeUpdate(query);
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
    }







    // get the single user
    public User getUser(Connection connect, String userName) {
        User userExist = null;
        try {
            if (connect != null) {
                String query = "SELECT * FROM users WHERE user_name = '" + userName + "'";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    userExist = new User(rs.getString(2), rs.getString(3),
                            rs.getString(4), rs.getString(5));
                }
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
        return userExist;
    }

    // code to get all users in a list view
    public ArrayList<User> getAllUsers(Connection connect) {
        ArrayList<User> users = new ArrayList<>();
        try {
            if (connect != null) {
                String query = "SELECT  * FROM users";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    users.add(new User(rs.getInt(1), rs.getString(2),
                            rs.getString(3),rs.getString(4)));
                }
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
        return users;
    }

    // add the new user
    public void addUser(Connection connect, User user)  {
        try {
            if (connect != null) {
                String query = "INSERT INTO users (role, user_name, first_name, password) " +
                        "VALUES ('" + user.getRole() + "', '" + user.getUserName() + "', '"
                        + user.getFirstName() + "', '" + user.getPassword() + "')";
                Statement st = connect.createStatement();
                st.executeUpdate(query);
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
    }

    // Deleting single user
    public void deleteUser(Connection connect, int userID) {
        try {
            if (connect != null) {
                String query = "DELETE FROM users WHERE id = " + userID;
                Statement st = connect.createStatement();
                st.executeUpdate(query);
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
    }
}