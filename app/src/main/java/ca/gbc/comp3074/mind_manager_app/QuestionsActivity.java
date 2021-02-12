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

        //Database instance
        final DatabaseHandler db = new DatabaseHandler(this);

        TextView question1 = findViewById(R.id.lblq1);
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

        /*
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
        */

        // Question 1
        Question q1 = db.getQuestion();
        question1.setText(q1.getQuestionText());
        q1_a1.setText(q1.getAnswer1());
        q1_a2.setText(q1.getAnswer2());
        q1_a3.setText(q1.getAnswer3());

        // Question 2
        Question q2;
        do {
           q2 = db.getQuestion();
        }while(q2.getID() == q1.getID());
        question2.setText(q2.getQuestionText());
        q2_a1.setText(q2.getAnswer1());
        q2_a2.setText(q2.getAnswer2());
        q2_a3.setText(q2.getAnswer3());

        // Question 3
        Question q3;
        do {
            q3 = db.getQuestion();
        }while(q3.getID() == q1.getID() || q3.getID() == q2.getID());
        question3.setText(q3.getQuestionText());
        q3_a1.setText(q3.getAnswer1());
        q3_a2.setText(q3.getAnswer2());
        q3_a3.setText(q3.getAnswer3());

        // Question 4
        Question q4;
        do {
            q4 = db.getQuestion();
        }while(q4.getID() == q1.getID() || q4.getID() == q2.getID() || q4.getID() == q3.getID());
        question4.setText(q4.getQuestionText());
        q4_a1.setText(q4.getAnswer1());
        q4_a2.setText(q4.getAnswer2());
        q4_a3.setText(q4.getAnswer3());

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