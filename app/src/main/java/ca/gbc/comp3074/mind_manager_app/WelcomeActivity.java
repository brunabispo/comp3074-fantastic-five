package ca.gbc.comp3074.mind_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btnIdk = findViewById(R.id.btnIdk);

        //Button "I don't know" goes to questionnaire page answer questions to determine their mood(QuestionActivity)
        btnIdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIDontKnow();
            }
        });

        Button btnGo = findViewById(R.id.btnGo);

        //Button Go goes to the suggestions page (SuggestionsActivity)
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSuggestions();
            }
        });


    }

    //function to start QuestionsActivity
    private void openIDontKnow(){
        Intent start = new Intent(getApplicationContext(), QuestionsActivity.class);
        startActivity(start);
    }

    // Open the Suggestions Page
    private void openSuggestions(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivity.class);
        startActivity(start);
    }




}
