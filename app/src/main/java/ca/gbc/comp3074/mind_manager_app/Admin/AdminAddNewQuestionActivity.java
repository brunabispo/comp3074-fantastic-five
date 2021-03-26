package ca.gbc.comp3074.mind_manager_app.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.Connection;
import ca.gbc.comp3074.mind_manager_app.GoogleMySQLConnectionHelper;
import ca.gbc.comp3074.mind_manager_app.Models.Answer;
import ca.gbc.comp3074.mind_manager_app.Models.Question;
import ca.gbc.comp3074.mind_manager_app.R;

public class AdminAddNewQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_question);

        //Database instance
        final GoogleMySQLConnectionHelper db = new GoogleMySQLConnectionHelper();
        final Connection connect = db.connectionclass();
        final String newQuestion = ((EditText) findViewById(R.id.lblNewQuestion)).getText().toString();
        final String answer1 = ((EditText) findViewById(R.id.lblAnswer1)).getText().toString();
        final String answer2 = ((EditText) findViewById(R.id.lblAnswer2)).getText().toString();
        final String answer3 = ((EditText) findViewById(R.id.lblAnswer3)).getText().toString();

        final String ans1Bored = ((EditText) findViewById(R.id.lblAns1Bored)).getText().toString();
        final String ans1Energetic = ((EditText) findViewById(R.id.lblAns1Energ)).getText().toString();
        final String ans1Happy = ((EditText) findViewById(R.id.lblAns1Happy)).getText().toString();
        final String ans1Sad = ((EditText) findViewById(R.id.lblAns1Sad)).getText().toString();
        final String ans1Tired = ((EditText) findViewById(R.id.lblAns1Tired)).getText().toString();

        final String ans2Bored = ((EditText) findViewById(R.id.lblAns2Bored)).getText().toString();
        final String ans2Energetic = ((EditText) findViewById(R.id.lblAns2Energ)).getText().toString();
        final String ans2Happy = ((EditText) findViewById(R.id.lblAns2Happy)).getText().toString();
        final String ans2Sad = ((EditText) findViewById(R.id.lblAns2Sad)).getText().toString();
        final String ans2Tired = ((EditText) findViewById(R.id.lblAns2Tired)).getText().toString();

        final String ans3Bored = ((EditText) findViewById(R.id.lblAns3Bored)).getText().toString();
        final String ans3Energetic = ((EditText) findViewById(R.id.lblAns3Energ)).getText().toString();
        final String ans3Happy = ((EditText) findViewById(R.id.lblAns3Happy)).getText().toString();
        final String ans3Sad = ((EditText) findViewById(R.id.lblAns3Sad)).getText().toString();
        final String ans3Tired = ((EditText) findViewById(R.id.lblAns3Tired)).getText().toString();

        final TextView lblError = findViewById(R.id.lblError);

        //Button Submit add a new question
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Execute the query, find if username input from user is existing in data base
                Question questionExist = db.getQuestionByText(connect, newQuestion);

                if(questionExist != null){
                    lblError.setText("This question is already exist");
                }
                else if (newQuestion.equals("") || answer1.equals("") || answer2.equals("")
                        || answer3.equals("") || ans1Bored.equals("") || ans1Energetic.equals("")
                        || ans1Happy.equals("") || ans1Sad.equals("") || ans1Tired.equals("")
                        || ans2Bored.equals("") || ans2Energetic.equals("") || ans2Happy.equals("")
                        || ans2Sad.equals("") || ans2Tired.equals("") || ans3Bored.equals("")
                        || ans3Energetic.equals("") || ans3Happy.equals("") || ans3Sad.equals("")
                        || ans3Tired.equals("")){
                    lblError.setText("All fields are required");
                } else{
                    final int ans1Bored = Integer.parseInt(((EditText) findViewById(R.id.lblAns1Bored)).getText().toString());
                    final int ans1Energetic = Integer.parseInt(((EditText) findViewById(R.id.lblAns1Energ)).getText().toString());
                    final int ans1Happy = Integer.parseInt(((EditText) findViewById(R.id.lblAns1Happy)).getText().toString());
                    final int ans1Sad = Integer.parseInt(((EditText) findViewById(R.id.lblAns1Sad)).getText().toString());
                    final int ans1Tired = Integer.parseInt(((EditText) findViewById(R.id.lblAns1Tired)).getText().toString());

                    final int ans2Bored = Integer.parseInt(((EditText) findViewById(R.id.lblAns2Bored)).getText().toString());
                    final int ans2Energetic = Integer.parseInt(((EditText) findViewById(R.id.lblAns2Energ)).getText().toString());
                    final int ans2Happy = Integer.parseInt(((EditText) findViewById(R.id.lblAns2Happy)).getText().toString());
                    final int ans2Sad = Integer.parseInt(((EditText) findViewById(R.id.lblAns2Sad)).getText().toString());
                    final int ans2Tired = Integer.parseInt(((EditText) findViewById(R.id.lblAns2Tired)).getText().toString());

                    final int ans3Bored = Integer.parseInt(((EditText) findViewById(R.id.lblAns3Bored)).getText().toString());
                    final int ans3Energetic = Integer.parseInt(((EditText) findViewById(R.id.lblAns3Energ)).getText().toString());
                    final int ans3Happy = Integer.parseInt(((EditText) findViewById(R.id.lblAns3Happy)).getText().toString());
                    final int ans3Sad = Integer.parseInt(((EditText) findViewById(R.id.lblAns3Sad)).getText().toString());
                    final int ans3Tired = Integer.parseInt(((EditText) findViewById(R.id.lblAns3Tired)).getText().toString());
                    //Insert new question
                    Question question = new Question(newQuestion+"");
                    db.addQuestion(connect, question);
                    questionExist = db.getQuestionByText(connect, question.getQuestionText()+"");
                    int questionID = questionExist.getID();
                    Answer ans1 = new Answer (questionID, answer1+"",
                            ans1Bored, ans1Energetic, ans1Happy, ans1Sad, ans1Tired);
                    Answer ans2 = new Answer (questionID, answer2+"",
                            ans2Bored, ans2Energetic, ans2Happy, ans2Sad, ans2Tired);
                    Answer ans3 = new Answer (questionID, answer3+"",
                            ans3Bored, ans3Energetic, ans3Happy, ans3Sad, ans3Tired);
                    db.addAnswer(connect, ans1);
                    db.addAnswer(connect, ans2);
                    db.addAnswer(connect, ans3);
                    backToAdminQuestionnaire();
                }
            }
        });

        //Button Cancel goes back to AdminQuestionnaireActivity
        Button btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToAdminQuestionnaire();
            }
        });
    }

    //function to start AdminQuestionnaireActivity
    private void backToAdminQuestionnaire(){
        Intent start = new Intent(getApplicationContext(), AdminQuestionnaireActivity.class);
        startActivity(start);
    }
}