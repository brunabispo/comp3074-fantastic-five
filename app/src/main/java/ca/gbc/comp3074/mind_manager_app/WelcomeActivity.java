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

        //Button Sad goes to the suggestions page (SuggestionsActivitySad)
        Button Sad = findViewById(R.id.btnSad);
        Sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSad();
            }
        });

        //Button Happy goes to the suggestions page (SuggestionsActivityHappy)
        Button Happy = findViewById(R.id.btnHappy);
        Happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHappy();
            }
        });

        //Button Energetic goes to the suggestions page (SuggestionsActivityEnergetic)
        Button Energetic = findViewById(R.id.btnEnergetic);
        Energetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEnergetic();
            }
        });

        //Button Bored goes to the suggestions page (SuggestionsActivityBored)
        Button Bored = findViewById(R.id.btnBored);
        Bored.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBored();
            }
        });

        //Button Tired goes to the suggestions page (SuggestionsActivityTired)
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

    // Open Sad suggestions
    private void openSad(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivitySad.class);
        startActivity(start);
    }

    // Open Happy suggestions
    private void openHappy(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivityHappy.class);
        startActivity(start);
    }

    // Open Energetic suggestions
    private void openEnergetic(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivityEnergetic.class);
        startActivity(start);
    }

    // Open Bored suggestions
    private void openBored(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivityBored.class);
        startActivity(start);
    }

    // Open Tired suggestions
    private void openTired(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivityTired.class);
        startActivity(start);
    }
    




}
