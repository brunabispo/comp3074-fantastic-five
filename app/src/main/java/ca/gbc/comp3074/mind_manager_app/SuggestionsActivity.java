package ca.gbc.comp3074.mind_manager_app;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class  SuggestionsActivity extends AppCompatActivity {

    // List<Suggestion> list; // List of suggestions

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions_2);

        ImageButton btnMap = findViewById(R.id.btn_map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        TextView title = findViewById(R.id.lblTitle3);
        Intent intent = getIntent();
        final String moodTitle = intent.getStringExtra("Mood");
        title.setText("Here are your suggestions for being more " + moodTitle);

        //Database instance
        final GoogleMySQLConnectionHelper db = new GoogleMySQLConnectionHelper();
//        list = new ArrayList<Suggestion>();
        
        TextView lblMusicCategory = findViewById(R.id.lblMusicCategory);
        final TextView lblMusicSuggestion = findViewById(R.id.lblMusicSuggestion);
        Button btnPlayMusic = findViewById(R.id.btnPlayMusic);

        TextView lblGameCategory = findViewById(R.id.lblGameCategory);
        final TextView lblGameSuggestion = findViewById(R.id.lblGameSuggestion);
        Button btnPlayGame = findViewById(R.id.btnPlayGame);

        TextView lblReadingCategory = findViewById(R.id.lblReadingCategory);
        final TextView lblReadingSuggestion = findViewById(R.id.lblReadingSuggestion);
        Button btnPlayReading = findViewById(R.id.btnPlayReading);

        final Suggestion musicSuggestion = new Suggestion();
        final Suggestion sportSuggestion = new Suggestion();
        final Suggestion outDoorSuggestion = new Suggestion();
        final Suggestion gameSuggestion = new Suggestion();
        final Suggestion poetrySuggestion = new Suggestion();
        musicSuggestion.setCategoryName("Music");
        sportSuggestion.setCategoryName("Sport");
        outDoorSuggestion.setCategoryName("Outdoors");
        gameSuggestion.setCategoryName("Games");
        poetrySuggestion.setCategoryName("Reading");

        if (moodTitle.equals("Calmer")) {
            musicSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Reading").getSuggestionName());

            lblMusicSuggestion.setText(musicSuggestion.getSuggestionName());
            lblGameSuggestion.setText(gameSuggestion.getSuggestionName());
            lblReadingSuggestion.setText(poetrySuggestion.getSuggestionName());
        }
        if (moodTitle.equals("Energetic"))
        {
            musicSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Reading").getSuggestionName());

            lblMusicSuggestion.setText(musicSuggestion.getSuggestionName());
            lblGameSuggestion.setText(gameSuggestion.getSuggestionName());
            lblReadingSuggestion.setText(poetrySuggestion.getSuggestionName());
        }
        if (moodTitle.equals("Happier"))
        {
            musicSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Reading").getSuggestionName());

            lblMusicSuggestion.setText(musicSuggestion.getSuggestionName());
            lblGameSuggestion.setText(gameSuggestion.getSuggestionName());
            lblReadingSuggestion.setText(poetrySuggestion.getSuggestionName());

        }
        if (moodTitle.equals("Moody"))
        {
            musicSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Reading").getSuggestionName());

            lblMusicSuggestion.setText(musicSuggestion.getSuggestionName());
            lblGameSuggestion.setText(gameSuggestion.getSuggestionName());
            lblReadingSuggestion.setText(poetrySuggestion.getSuggestionName());
        }
        if (moodTitle.equals("Relaxed"))
        {
            musicSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Reading").getSuggestionName());

            lblMusicSuggestion.setText(musicSuggestion.getSuggestionName());
            lblGameSuggestion.setText(gameSuggestion.getSuggestionName());
            lblReadingSuggestion.setText(poetrySuggestion.getSuggestionName());
        }

        ImageButton btnRandom = findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                list.remove(musicSuggestion);
//                list.remove(sportSuggestion);
//                list.remove(outDoorSuggestion);
//                list.remove(gameSuggestion);
//                list.remove(poetrySuggestion);

                lblMusicSuggestion.setText("");
                lblGameSuggestion.setText("");
                lblReadingSuggestion.setText("");

                if (moodTitle.equals("Calmer")) {
                    musicSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Reading").getSuggestionName());

                    lblMusicSuggestion.setText(musicSuggestion.getSuggestionName());
                    lblGameSuggestion.setText(gameSuggestion.getSuggestionName());
                    lblReadingSuggestion.setText(poetrySuggestion.getSuggestionName());
                }
                if (moodTitle.equals("Energetic"))
                {
                    musicSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Reading").getSuggestionName());

                    lblMusicSuggestion.setText(musicSuggestion.getSuggestionName());
                    lblGameSuggestion.setText(gameSuggestion.getSuggestionName());
                    lblReadingSuggestion.setText(poetrySuggestion.getSuggestionName());
                }
                if (moodTitle.equals("Happier"))
                {
                    musicSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Reading").getSuggestionName());

                    lblMusicSuggestion.setText(musicSuggestion.getSuggestionName());
                    lblGameSuggestion.setText(gameSuggestion.getSuggestionName());
                    lblReadingSuggestion.setText(poetrySuggestion.getSuggestionName());
                }
                if (moodTitle.equals("Moody"))
                {
                    musicSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Reading").getSuggestionName());

                    lblMusicSuggestion.setText(musicSuggestion.getSuggestionName());
                    lblGameSuggestion.setText(gameSuggestion.getSuggestionName());
                    lblReadingSuggestion.setText(poetrySuggestion.getSuggestionName());
                }
                if (moodTitle.equals("Relaxed"))
                {
                    musicSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(moodTitle, "Reading").getSuggestionName());

                    lblMusicSuggestion.setText(musicSuggestion.getSuggestionName());
                    lblGameSuggestion.setText(gameSuggestion.getSuggestionName());
                    lblReadingSuggestion.setText(poetrySuggestion.getSuggestionName());
                }

//                list.add(musicSuggestion);
//                list.add(sportSuggestion);
//                list.add(outDoorSuggestion);
//                list.add(gameSuggestion);
//                list.add(poetrySuggestion);

//                ArrayAdapter<Suggestion> adapter = new SuggestionArrayAdapter(SuggestionsActivity.this,
//                        R.layout.row_layout_suggestions, R.id.lblCategory, R.id.lblSuggestion, list);
//
//                setListAdapter(adapter);
            }
        });
//
//        list.add(musicSuggestion);
//        list.add(sportSuggestion);
//        list.add(outDoorSuggestion);
//        list.add(gameSuggestion);
//        list.add(poetrySuggestion);
//
//        ArrayAdapter<Suggestion> adapter = new SuggestionArrayAdapter(this,
//                R.layout.row_layout_suggestions, R.id.lblCategory, R.id.lblSuggestion, list);
//
//        setListAdapter(adapter);
    }

    // Open the Map Page
    private void openMap(){
        Intent start = new Intent(getApplicationContext(), MapActivity.class);
        startActivity(start);
    }
}