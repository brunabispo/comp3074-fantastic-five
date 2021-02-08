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

        //Button Sad goes to the suggestions page (SuggestionsActivity)
        Button Sad = findViewById(R.id.btnSad);
        Sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSad();
            }
        });

        //Button Happy goes to the suggestions page (SuggestionsActivity)
        Button Happy = findViewById(R.id.btnHappy);
        Happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHappy();
            }
        });

        //Button Energetic goes to the suggestions page (SuggestionsActivity)
        Button Energetic = findViewById(R.id.btnEnergetic);
        Energetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEnergetic();
            }
        });

        //Button Bored goes to the suggestions page (SuggestionsActivity)
        Button Bored = findViewById(R.id.btnBored);
        Bored.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBored();
            }
        });

        //Button Tired goes to the suggestions page (SuggestionsActivity)
        Button Tired = findViewById(R.id.btnTired);
        Tired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTired();
            }
        });
    }

    //function to start QuestionsActivity
    private void openIDontKnow(){
        Intent start = new Intent(getApplicationContext(), QuestionsActivity.class);
        startActivity(start);
    }

    // Open Bored suggestions
    private void openBored(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivity.class);
        String mood = "Bored";
        start.putExtra("Mood", mood);
        startActivity(start);
    }

    // Open Energetic suggestions
    private void openEnergetic(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivity.class);
        String mood = "Energetic";
        start.putExtra("Mood", mood);
        startActivity(start);
    }

    // Open Happy suggestions
    private void openHappy(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivity.class);
        String mood = "Happy";
        start.putExtra("Mood", mood);
        startActivity(start);
    }

    // Open Sad suggestions
    private void openSad(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivity.class);
        String mood = "Sad";
        start.putExtra("Mood", mood);
        startActivity(start);
    }

    // Open Tired suggestions
    private void openTired(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivity.class);
        String mood = "Tired";
        start.putExtra("Mood", mood);
        startActivity(start);
    }
}