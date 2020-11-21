package ca.gbc.comp3074.mind_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Logic to still be implemented
        switch(view.getId()) {
            case R.id.rbtn_q1_1:
                break;
            case R.id.rbtn_q1_2:
                break;
            case R.id.rbtn_q1_3:
                break;
            case R.id.rbtn_q2_1:
                break;
            case R.id.rbtn_q2_2:
                break;
            case R.id.rbtn_q2_3:
                break;
            case R.id.rbtn_q3_1:
                break;
            case R.id.rbtn_q3_2:
                break;
            case R.id.rbtn_q3_3:
                break;
            case R.id.rbtn_q4_1:
                break;
            case R.id.rbtn_q4_2:
                break;
            case R.id.rbtn_q4_3:
                break;
        }
    }
}
