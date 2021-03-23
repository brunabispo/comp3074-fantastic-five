package ca.gbc.comp3074.mind_manager_app.Admin;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.sql.Connection;
import java.util.List;

import ca.gbc.comp3074.mind_manager_app.GoogleMySQLConnectionHelper;
import ca.gbc.comp3074.mind_manager_app.MainActivity;
import ca.gbc.comp3074.mind_manager_app.Models.Question;
import ca.gbc.comp3074.mind_manager_app.Models.QuestionArrayAdapter;
import ca.gbc.comp3074.mind_manager_app.R;

public class AdminQuestionnaireActivity extends ListActivity {

    List<Question> questions;
    TextView lblError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_questionnaire);

        //Database instance
        final GoogleMySQLConnectionHelper db = new GoogleMySQLConnectionHelper();
        final Connection connect = db.connectionclass();

        printArray(connect, db);
/*
        Button btnAddNewQuestion = findViewById(R.id.btnAddQuestion);
        btnAddNewQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //addNewQuestion(db);
            }
        });
*/
        Button btnLogOut = findViewById(R.id.btnLogoutAdminQuestionnaire);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogOut();
            }
        });
    }

    //print array of all users
    private void printArray(Connection connect, GoogleMySQLConnectionHelper db){
        questions = db.getAllQuestions(connect);
        StringBuilder sb = new StringBuilder();
        int size = questions.size();
        boolean appendSeparator = false;
        for(int y=0; y < size; y++){
            if (appendSeparator)
                sb.append(','); // a comma
            appendSeparator = true;
            sb.append(questions.get(y));
        }
        ArrayAdapter<Question> myAdapter = new QuestionArrayAdapter(this, questions);
        setListAdapter(myAdapter);
    }

    private void openLogOut(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }
}