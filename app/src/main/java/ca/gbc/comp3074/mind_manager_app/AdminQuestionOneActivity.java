package ca.gbc.comp3074.mind_manager_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminQuestionOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_question_one);

        Button btnEditQuestionOne = findViewById(R.id.btnAdminEditQuestionOne);
        Button btnEditAnswerOne = findViewById(R.id.btnAdminEditAnswerOne);
        Button btnRemoveAnswerOne = findViewById(R.id.btnAdminRemoveAnswerOne);
        Button btnEditAnswerTwo = findViewById(R.id.btnAdminEditAnswerTwo);
        Button btnRemoveAnswerTwo = findViewById(R.id.btnAdminRemoveAnswerTwo);
        Button btnEditAnswerThree = findViewById(R.id.btnAdminEditAnswerThree);
        Button btnRemoveAnswerThree = findViewById(R.id.btnAdminRemoveAnswerThree);
        Button btnDeleteQuestionOne = findViewById(R.id.btnAdminDeleteQuestionOne);
        Button btnLogout = findViewById(R.id.btnLogoutAdminQuestionOne);
    }



}
