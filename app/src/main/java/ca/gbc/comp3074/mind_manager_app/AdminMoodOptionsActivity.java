package ca.gbc.comp3074.mind_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        Button btnLogOut = findViewById(R.id.btnLogoutAdminMoodOptions);
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