package ca.gbc.comp3074.mind_manager_app.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.Connection;
import java.util.List;

import ca.gbc.comp3074.mind_manager_app.GoogleMySQLConnectionHelper;
import ca.gbc.comp3074.mind_manager_app.MainActivity;
import ca.gbc.comp3074.mind_manager_app.Models.Answer;
import ca.gbc.comp3074.mind_manager_app.Models.Question;
import ca.gbc.comp3074.mind_manager_app.R;

public class AdminAnswersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_answers);

        Question question;
        //Database instance
        final GoogleMySQLConnectionHelper db = new GoogleMySQLConnectionHelper();
        final Connection connect = db.connectionclass();

        Button btnEditQuestionOne = findViewById(R.id.btnAdminEditQuestionOne);
        Button btnEditAnswerOne = findViewById(R.id.btnAdminEditAnswerOne);
        Button btnEditAnswerTwo = findViewById(R.id.btnAdminEditAnswerTwo);
        Button btnEditAnswerThree = findViewById(R.id.btnAdminEditAnswerThree);
        Button btnDeleteQuestionOne = findViewById(R.id.btnAdminDeleteQuestionOne);

        TextView title = findViewById(R.id.lbl_questionNum);
        Intent intent = getIntent();
        int questionID = intent.getIntExtra("id", 1);
        title.setText("Question " + questionID);

        TextView text = findViewById(R.id.lbl_questionText);
        question = db.getQuestionByID(connect, questionID);
        text.setText(question.getQuestionText());

        List<Answer> answers = question.getAnswers();

        TextView answer1 = findViewById(R.id.lbl_answer1);
        answer1.setText(answers.get(0).getText());

        TextView answer2 = findViewById(R.id.lbl_answer2);
        answer2.setText(answers.get(1).getText());

        TextView answer3 = findViewById(R.id.lbl_answer3);
        answer3.setText(answers.get(2).getText());

        Button btnLogOut = findViewById(R.id.btnLogoutAdminAnswers);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogOut();
            }
        });
    }

    private void openLogOut(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }
}