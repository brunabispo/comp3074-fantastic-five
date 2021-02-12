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

        //Button Moody goes to the suggestions page (SuggestionsActivity)
        Button Moody = findViewById(R.id.btnMoody);
        Moody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMoody();
            }
        });

        //Button Happier goes to the suggestions page (SuggestionsActivity)
        Button Happier = findViewById(R.id.btnHappier);
        Happier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHappier();
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

        //Button Calmer goes to the suggestions page (SuggestionsActivity)
        Button Calmer = findViewById(R.id.btnCalmer); //
        Calmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalmer();
            }
        });

        //Button Relaxed goes to the suggestions page (SuggestionsActivity)
        Button Relaxed = findViewById(R.id.btnRelaxed);
        Relaxed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRelaxed();
            }
        });
    }

    //function to start QuestionsActivity
    private void openIDontKnow(){
        Intent start = new Intent(getApplicationContext(), QuestionsActivity.class);
        startActivity(start);
    }

    // Open Calmer suggestions
    private void openCalmer(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivity.class);
        String mood = "Calmer";
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

    // Open Happier suggestions
    private void openHappier(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivity.class);
        String mood = "Happier";
        start.putExtra("Mood", mood);
        startActivity(start);
    }

    // Open Moody suggestions
    private void openMoody(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivity.class);
        String mood = "Moody";
        start.putExtra("Mood", mood);
        startActivity(start);
    }

    // Open Tired suggestions
    private void openRelaxed(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivity.class);
        String mood = "Relaxed";
        start.putExtra("Mood", mood);
        startActivity(start);
    }
}