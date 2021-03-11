package ca.gbc.comp3074.mind_manager_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GoogleMySQLConnectionHelper {

    String username, password, ip, port, database;
    Connection connection = null;

    // make connection with MySQL instance
    public Connection connectionclass(){
        ip = "34.69.115.126";
        port = "3306";
        database = "mindmanager";
        username = "root";
        password = "georgebrown";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://34.69.115.126:3306/mindmanager?characterEncoding=utf8", username, password);
        }
        catch (Exception exception){
            Log.e("Error: ", exception.getMessage());
        }

        return connection;
    }

    // get a suggestion by mood and category
    Suggestion getSuggestion(String mood, String category) {
        Connection connect;
        Suggestion suggestionExist = null;
        try {
            GoogleMySQLConnectionHelper connectionHelper = new GoogleMySQLConnectionHelper();
            connect = connectionHelper.connectionclass();
            if (connect != null) {
                String query = "SELECT * FROM suggestions WHERE mood IN ('" + mood + "') AND " +
                        "category_name IN ('" + category + "') ORDER BY RAND() LIMIT 1";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    suggestionExist = new Suggestion(rs.getInt(1),rs.getString(2),
                            rs.getString(3), rs.getString(4));
                }
                connect.close();
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
        return suggestionExist;
    }

    //get the random question
    public Question getRandomQuestion() {
        Connection connect;
        Question randomQuestion = null;
        try {
            GoogleMySQLConnectionHelper connectionHelper = new GoogleMySQLConnectionHelper();
            connect = connectionHelper.connectionclass();
            if (connect != null) {
                String query = "SELECT * FROM questions ORDER BY RAND() LIMIT 1";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    ArrayList<Answer> answers = getAnswers(rs.getInt(1));
                    randomQuestion = new Question(rs.getInt(1),rs.getString(2), answers);
                }
                connect.close();
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
        return randomQuestion;
    }

    //get answers for question by questionId
    ArrayList<Answer> getAnswers(int questionId) {
        Connection connect;
        ArrayList<Answer> answers = new ArrayList<>();
        try {
            GoogleMySQLConnectionHelper connectionHelper = new GoogleMySQLConnectionHelper();
            connect = connectionHelper.connectionclass();
            if (connect != null) {
                String query = "SELECT * FROM answers WHERE question_id = " + questionId;
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    answers.add(new Answer(rs.getInt(1), rs.getInt(2),
                            rs.getString(3), rs.getInt(4), rs.getInt(5),
                            rs.getInt(6), rs.getInt(7), rs.getInt(8)));
                }
                connect.close();
            }
        } catch (Exception exception) {
            Log.e("Error: ", exception.getMessage());
        }
        return answers;
    }
}