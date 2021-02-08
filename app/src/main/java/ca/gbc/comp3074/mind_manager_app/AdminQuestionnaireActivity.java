package ca.gbc.comp3074.mind_manager_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminQuestionnaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_questionnaire);

        Button btnViewQuestionOne = findViewById(R.id.btnViewQuestionOne);
        Button btnViewQuestionTwo = findViewById(R.id.btnViewQuestionTwo);
        Button btnViewQuestionThree = findViewById(R.id.btnViewQuestionThree);
        Button btnViewQuestionFour = findViewById(R.id.btnViewQuestionFour);
        Button btnAddNewQuestion = findViewById(R.id.btnAddQuestion);
        Button btnLogout = findViewById(R.id.btnLogoutAdminHome);

        btnViewQuestionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionOne();
            }
        });

        btnViewQuestionTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionTwo();
            }
        });

        btnViewQuestionThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionThree();
            }
        });

        btnViewQuestionFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionFour();
            }
        });
    }

    private void openQuestionOne(){

    }

    private void openQuestionTwo(){

    }

    private void openQuestionThree(){

    }

    private void openQuestionFour(){

    }

}
