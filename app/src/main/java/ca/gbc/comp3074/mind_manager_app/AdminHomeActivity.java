package ca.gbc.comp3074.mind_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AdminHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        Button btnCurrentUsers = findViewById(R.id.btnCurrentUsers);
        Button btnMoodOptions = findViewById(R.id.btnMoodOptions);
        Button btnQuestionnaire = findViewById(R.id.btnQuestionnaire);
        Button btnCategories = findViewById(R.id.btnCategories);
        Button btnLogOut = findViewById(R.id.btnLogoutAdminHome);

        btnCurrentUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCurrentUsers();
            }
        });

        btnMoodOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMoodOptions();
            }
        });

        btnQuestionnaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionnaire();
            }
        });

        btnCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategories();
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogOut();
            }
        });
    }

    private void openCurrentUsers(){
        Intent start = new Intent(getApplicationContext(), AdminCurrentUsersActivity.class);
        startActivity(start);
    }

    private void openMoodOptions(){
        Intent start = new Intent(getApplicationContext(), AdminMoodOptionsActivity.class);
        startActivity(start);
    }

    private void openQuestionnaire(){
        Intent start = new Intent(getApplicationContext(), AdminQuestionnaireActivity.class);
        startActivity(start);
    }

    private void openCategories(){
        Intent start = new Intent(getApplicationContext(), AdminCategoriesActivity.class);
        startActivity(start);
    }

    private void openLogOut(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }
}