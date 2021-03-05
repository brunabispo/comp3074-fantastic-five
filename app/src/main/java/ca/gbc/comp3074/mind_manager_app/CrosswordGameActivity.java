package ca.gbc.comp3074.mind_manager_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.share.widget.ShareButton;

import java.util.Arrays;
import java.util.List;

public class CrosswordGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_crossword);

        Intent intent = getIntent();
        final String moodTitle = intent.getStringExtra("Mood");

        String[] moody = {"overwhelm", "emotional", "reflective", "melancholy"};
        String[] happier = {"cheerful", "ecstatic", "overjoyed", "joyful"};
        String[] energetic = {"active", "dynamic", "spirited", "tireless"};
        String[] calmer = {"serene", "soothing", "tranquil", "pacific"};
        String[] relaxed = {"casual", "laid back", "tranquil", "patient"};
        final List<String> list = Arrays.asList(moodTitle.toLowerCase());

        final TextView lblResult = findViewById(R.id.lblResultGame);
        final EditText editUserInput = findViewById(R.id.editInputNumberCross);

        // final String numberOfWords = "2";
        final int numOfWords = list.size();

        Button btnImDone = findViewById(R.id.btnImDone);
        btnImDone.setOnClickListener(new View.OnClickListener() {
            int counter = 0;
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
//                while(counter != numOfWords) {
                    if(list.contains(editUserInput.getText().toString().toLowerCase()) && counter < numOfWords) {
                        counter++;
                        lblResult.setText("Congratulations! There is more.");
                    }
                    if(counter == numOfWords) {
                        lblResult.setText("Congratulations! You did it!");
                    }
            }
        });
    }

    //function to start AboutActivity
    private void openAbout(){
        Intent start = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(start);
    }

    private void openlogin(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            openAbout();
            return true;
        }
        if (item.getItemId() == R.id.menu_main) {
            openlogin();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
