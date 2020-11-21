package ca.gbc.comp3074.mind_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Button btnSubmit = findViewById(R.id.btn_submit);

        //Button Submit goes to the suggestions page (SuggestionsActivity)
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSuggestions();
            }
        });
    }

    // Open the Suggestions Page
    private void openSuggestions(){
        Intent start = new Intent(getApplicationContext(), SuggestionsActivity.class);
        startActivity(start);
    }
}
