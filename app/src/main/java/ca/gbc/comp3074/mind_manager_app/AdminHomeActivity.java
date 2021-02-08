package ca.gbc.comp3074.mind_manager_app;

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
        Button btnLogout = findViewById(R.id.btnLogoutAdminHome);

        btnCurrentUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCurrentUsers();
            }
        });

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
    }

    private void openCurrentUsers(){

    }

    private void openMoodOptions(){

    }

    private void openQuestionnaire(){

    }

    private void openCategories(){

    }
}
