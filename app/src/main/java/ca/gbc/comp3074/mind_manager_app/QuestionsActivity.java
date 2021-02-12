package ca.gbc.comp3074.mind_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //TextView question1 = findViewById(R.id.lblq1);
        TextView question2 = findViewById(R.id.lblq2);
        TextView question3 = findViewById(R.id.lblq3);
        TextView question4 = findViewById(R.id.lblq4);

        RadioButton q1_a1 = findViewById(R.id.rbtn_q1_1);
        RadioButton q1_a2 = findViewById(R.id.rbtn_q1_2);
        RadioButton q1_a3 = findViewById(R.id.rbtn_q1_3);

        RadioButton q2_a1 = findViewById(R.id.rbtn_q2_1);
        RadioButton q2_a2 = findViewById(R.id.rbtn_q2_2);
        RadioButton q2_a3 = findViewById(R.id.rbtn_q2_3);

        RadioButton q3_a1 = findViewById(R.id.rbtn_q3_1);
        RadioButton q3_a2 = findViewById(R.id.rbtn_q3_2);
        RadioButton q3_a3 = findViewById(R.id.rbtn_q3_3);

        RadioButton q4_a1 = findViewById(R.id.rbtn_q4_1);
        RadioButton q4_a2 = findViewById(R.id.rbtn_q4_2);
        RadioButton q4_a3 = findViewById(R.id.rbtn_q4_3);

        //question 1 - "Do I feel like I want to be alone right now?"
        Answer answer1 = new Answer();
        answer1.setText("Yes");
        answer1.setEnergeticRating(0);
        answer1.setBoredRating(5);
        answer1.setHappyRating(3);
        answer1.setSadRating(8);
        answer1.setTiredRating(10);

        Answer answer2 = new Answer();
        answer2.setText("No");
        answer2.setEnergeticRating(10);
        answer2.setBoredRating(5);
        answer2.setHappyRating(8);
        answer2.setSadRating(1);
        answer2.setTiredRating(0);

        Answer answer3 = new Answer();
        answer3.setText("I'm fine either way");
        answer3.setEnergeticRating(10);
        answer3.setBoredRating(5);
        answer3.setHappyRating(8);
        answer3.setSadRating(1);
        answer3.setTiredRating(0);

        ArrayList<Answer> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);

        Question question1 = new Question();
        question1.setAnswers(answers);

        // Question 2
        question2.setText("Did someone get on my nerves today?");
        q2_a1.setText("Yes");
        q2_a2.setText("No");
        q2_a3.setText("A little bit");

        // Question 3
        question3.setText("I am full of energy.");
        q3_a1.setText("Yes");
        q3_a2.setText("No");
        q3_a3.setText("I feel like I could literally bounce off the walls.");

        // Question 4
        question4.setText("I feel like going outside.");
        q4_a1.setText("Yes");
        q4_a2.setText("No");
        q4_a3.setText("Yes, but I'm lazy");

        Button btnSubmit = findViewById(R.id.btn_submit);

        //Button Submit goes to the suggestions page (SuggestionsActivitySad)
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
        String mood = "Moody";
        start.putExtra("Mood", mood);
        startActivity(start);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Logic to still be implemented
        switch(view.getId()) {

            case R.id.rbtn_q1_1 & R.id.rbtn_q2_1 & R.id.rbtn_q3_1 & R.id.rbtn_q4_1:
                if(checked){
                    openSuggestions();
                }
                break;
            case R.id.rbtn_q1_2:
                break;
            case R.id.rbtn_q1_3:
                break;
            case R.id.rbtn_q2_2:
                break;
            case R.id.rbtn_q2_3:
                break;
            case R.id.rbtn_q3_2:
                break;
            case R.id.rbtn_q3_3:
                break;
            case R.id.rbtn_q4_2:
                break;
            case R.id.rbtn_q4_3:
                break;
        }
    }
}