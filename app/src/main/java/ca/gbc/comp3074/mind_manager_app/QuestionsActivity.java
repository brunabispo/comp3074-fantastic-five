package ca.gbc.comp3074.mind_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.Connection;
import ca.gbc.comp3074.mind_manager_app.Models.Answer;
import ca.gbc.comp3074.mind_manager_app.Models.Question;

public class QuestionsActivity extends AppCompatActivity {

    private Question q1;
    private Question q2;
    private Question q3;
    private Question q4;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //Database instance
        GoogleMySQLConnectionHelper db = new GoogleMySQLConnectionHelper();
        final Connection connect = db.connectionclass();

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

        // Question 1
        q1 = db.getRandomQuestion(connect);
        question1.setText(q1.getQuestionText());
        q1_a1.setText(q1.getAnswers().get(0).getText());
        q1_a2.setText(q1.getAnswers().get(1).getText());
        q1_a3.setText(q1.getAnswers().get(2).getText());

        // Question 2
        do {
            q2 = db.getRandomQuestion(connect);
        }while(q2.getID() == q1.getID());
        question2.setText(q2.getQuestionText());
        q2_a1.setText(q2.getAnswers().get(0).getText());
        q2_a2.setText(q2.getAnswers().get(1).getText());
        q2_a3.setText(q2.getAnswers().get(2).getText());

        // Question 3
        do {
            q3 = db.getRandomQuestion(connect);
        }while(q3.getID() == q1.getID() || q3.getID() == q2.getID());
        question3.setText(q3.getQuestionText());
        q3_a1.setText(q3.getAnswers().get(0).getText());
        q3_a2.setText(q3.getAnswers().get(1).getText());
        q3_a3.setText(q3.getAnswers().get(2).getText());

        // Question 4
        do {
            q4 = db.getRandomQuestion(connect);
        }while(q4.getID() == q1.getID() || q4.getID() == q2.getID() || q4.getID() == q3.getID());
        question4.setText(q4.getQuestionText());
        q4_a1.setText(q4.getAnswers().get(0).getText());
        q4_a2.setText(q4.getAnswers().get(1).getText());
        q4_a3.setText(q4.getAnswers().get(2).getText());


        Button btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
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

                int chosenRadioButton1 = checkWhichClicked(q1_a1, q1_a2, q1_a3);
                int chosenRadioButton2 = checkWhichClicked(q2_a1, q2_a2, q2_a3);
                int chosenRadioButton3 = checkWhichClicked(q3_a1, q3_a2, q3_a3);
                int chosenRadioButton4 = checkWhichClicked(q4_a1, q4_a2, q4_a3);

                Answer q1SelectedAnswer = q1.getAnswers().get(chosenRadioButton1);
                Answer q2SelectedAnswer = q2.getAnswers().get(chosenRadioButton2);
                Answer q3SelectedAnswer = q3.getAnswers().get(chosenRadioButton3);
                Answer q4SelectedAnswer = q4.getAnswers().get(chosenRadioButton4);

                calculateMood(q1SelectedAnswer, q2SelectedAnswer, q3SelectedAnswer, q4SelectedAnswer);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
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

        int chosenRadioButton1 = checkWhichClicked(q1_a1, q1_a2, q1_a3);
        int chosenRadioButton2 = checkWhichClicked(q2_a1, q2_a2, q2_a3);
        int chosenRadioButton3 = checkWhichClicked(q3_a1, q3_a2, q3_a3);
        int chosenRadioButton4 = checkWhichClicked(q4_a1, q4_a2, q4_a3);

    }

    public void calculateMood(Answer answerSelected, Answer answerSelected2, Answer answerSelected3, Answer answerSelected4){
        int boredRating = answerSelected.getBoredRating() + answerSelected2.getBoredRating()
                + answerSelected3.getBoredRating() + answerSelected4.getBoredRating();

        int happyRating = answerSelected.getHappyRating() + answerSelected2.getHappyRating()
                + answerSelected3.getHappyRating() + answerSelected4.getHappyRating();

        int sadRating = answerSelected.getSadRating() + answerSelected2.getSadRating()
                + answerSelected3.getSadRating() + answerSelected4.getSadRating();

        int tiredRating = answerSelected.getTiredRating() + answerSelected2.getTiredRating()
                + answerSelected3.getTiredRating() + answerSelected4.getTiredRating();

        int energeticRating = answerSelected.getEnergeticRating() + answerSelected2.getEnergeticRating()
                + answerSelected3.getEnergeticRating() + answerSelected4.getEnergeticRating();

        calculateHighestRating(boredRating, happyRating, energeticRating, sadRating, tiredRating);
    }

    public void calculateHighestRating(int sumBoredRating, int sumHappyRating, int sumEnergeticRating, int sumSadRating, int sumTiredRating){
        int highestRating = 0;
        Intent start = null;

        if(sumBoredRating > highestRating){
            highestRating = sumBoredRating;
            start = new Intent(getApplicationContext(), SuggestionsActivity.class);
            String mood = "Calmer";
            start.putExtra("Mood", mood);
        }
        if(sumHappyRating > highestRating){
            highestRating = sumHappyRating;
            start = new Intent(getApplicationContext(), SuggestionsActivity.class);
            String mood = "Happy";
            start.putExtra("Mood", mood);
        }
        if(sumEnergeticRating > highestRating){
            highestRating = sumEnergeticRating;
            start = new Intent(getApplicationContext(), SuggestionsActivity.class);
            String mood = "Energetic";
            start.putExtra("Mood", mood);
        }
        if(sumSadRating > highestRating){
            highestRating = sumSadRating;
            start = new Intent(getApplicationContext(), SuggestionsActivity.class);
            String mood = "Moody";
            start.putExtra("Mood", mood);
        }
        if(sumTiredRating > highestRating){
            start = new Intent(getApplicationContext(), SuggestionsActivity.class);
            String mood = "Relaxed";
            start.putExtra("Mood", mood);
        }
        startActivity(start);
    }

    //checks each radio button if was checked (is input by the user) per question
    public int checkWhichClicked(RadioButton rb1, RadioButton rb2, RadioButton rb3){
        if(rb1.isChecked()){
            return 0;
        }
        else if(rb2.isChecked()){
            return 1;
        }
        else if(rb3.isChecked()){
            return 2;
        }
        return 0;
    }
}