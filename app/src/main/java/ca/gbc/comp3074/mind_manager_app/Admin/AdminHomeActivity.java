package ca.gbc.comp3074.mind_manager_app.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import ca.gbc.comp3074.mind_manager_app.MainActivity;
import ca.gbc.comp3074.mind_manager_app.R;

public class AdminHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        Button btnCurrentUsers = findViewById(R.id.btnCurrentUsers);
        btnCurrentUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCurrentUsers();
            }
        });

        Button btnQuestionnaire = findViewById(R.id.btnQuestionnaire);
        btnQuestionnaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionnaire();
            }
        });

        Button btnCategories = findViewById(R.id.btnCategories);
        btnCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategories();
            }
        });

        Button btnLogOut = findViewById(R.id.btnLogoutAdminHome);
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