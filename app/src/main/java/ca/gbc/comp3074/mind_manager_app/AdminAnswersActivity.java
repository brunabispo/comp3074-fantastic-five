package ca.gbc.comp3074.mind_manager_app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.sql.Connection;
import java.util.List;

public class AdminAnswersActivity extends ListActivity {

    List<Answer> answers;
    TextView lblError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_answers);

        Question question;
        //Database instance
        final GoogleMySQLConnectionHelper db = new GoogleMySQLConnectionHelper();
        final Connection connect = db.connectionclass();

        Button btnEditQuestionOne = findViewById(R.id.btnAdminEditQuestionOne);
        //Button btnEditAnswerOne = findViewById(R.id.btnAdminEditAnswerOne);
        //Button btnEditAnswerTwo = findViewById(R.id.btnAdminEditAnswerTwo);
        //Button btnEditAnswerThree = findViewById(R.id.btnAdminEditAnswerThree);
        Button btnDeleteQuestionOne = findViewById(R.id.btnAdminDeleteQuestionOne);

        TextView title = findViewById(R.id.lbl_questionNum);
        Intent intent = getIntent();
        int questionID = intent.getIntExtra("id", 1);
        title.setText("Question " + questionID);

        TextView text = findViewById(R.id.lbl_questionText);
        question = db.getQuestionByID(connect, questionID);
        text.setText(question.getQuestionText());

        List<Answer> answers = db.getAnswers(connect, questionID);
        printArray(answers);
        Button btnLogOut = findViewById(R.id.btnLogoutAdminAnswers);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogOut();
            }
        });
    }


    //print array of all users
    private void printArray(List<Answer> answers){
        StringBuilder sb = new StringBuilder();
        int size = answers.size();
        boolean appendSeparator = false;
        for(int y=0; y < size; y++){
            if (appendSeparator)
                sb.append(','); // a comma
            appendSeparator = true;
            sb.append(answers.get(y));
        }
        ArrayAdapter<Answer> myAdapter = new AnswersArrayAdapter(this, answers);
        setListAdapter(myAdapter);
    }

    private void openLogOut(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }
}