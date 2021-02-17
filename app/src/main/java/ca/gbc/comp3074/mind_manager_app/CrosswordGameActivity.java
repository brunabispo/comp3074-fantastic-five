package ca.gbc.comp3074.mind_manager_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.share.widget.ShareButton;

public class CrosswordGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_crossword);

        String[] words = {"fear", "wellness"};

        final TextView lblResult = findViewById(R.id.lblResultGame);
        final EditText editUserInput = findViewById(R.id.editInputNumberCross);

        final String numberOfWords = "2";

        Button btnImDone = findViewById(R.id.btnImDone);
        btnImDone.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(editUserInput.getText().toString().equals(numberOfWords)) {
                    lblResult.setText("Congratulations! You did it");
                }
                else {
                    lblResult.setText("Try again");
                }
            }
        });
    }
}
