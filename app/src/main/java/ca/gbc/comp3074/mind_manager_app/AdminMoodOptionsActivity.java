package ca.gbc.comp3074.mind_manager_app;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminMoodOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mood_options);

        Button btnHappy = findViewById(R.id.btnAdminHappy);
        Button btnSad = findViewById(R.id.btnAdminSad);
        Button btnAddNewMood = findViewById(R.id.btnAdminAddMood);
//        Have to add more moods
        Button btnLogout = findViewById(R.id.btnLogoutAdminMoodOptions);
    }

}
