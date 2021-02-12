package ca.gbc.comp3074.mind_manager_app;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SuggestionsActivity extends ListActivity {

    List<Suggestion> list; // List of suggestions

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        ImageButton btnMap = findViewById(R.id.btn_map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        TextView title = findViewById(R.id.lblTitle);
        Intent intent = getIntent();
        final String moodTitle = intent.getStringExtra("Mood");
        title.setText("Here are your suggestions for " + moodTitle);

        //Database instance
        final DatabaseHandler db = new DatabaseHandler(this);
        list = new ArrayList<Suggestion>();

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
            musicSuggestion.setSuggestionName(db.getSuggestion("Calmer", "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion("Calmer", "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion("Calmer", "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion("Calmer", "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion("Calmer", "Reading").getSuggestionName());
        }
        if (moodTitle.equals("Energetic"))
        {
            musicSuggestion.setSuggestionName(db.getSuggestion("Energetic", "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion("Energetic", "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion("Energetic", "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion("Energetic", "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion("Energetic", "Reading").getSuggestionName());
        }
        if (moodTitle.equals("Happier"))
        {
            musicSuggestion.setSuggestionName(db.getSuggestion("Happier", "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion("Happier", "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion("Happier", "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion("Happier", "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion("Happier", "Reading").getSuggestionName());

        }
        if (moodTitle.equals("Moody"))
        {
            musicSuggestion.setSuggestionName(db.getSuggestion("Moody", "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion("Moody", "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion("Moody", "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion("Moody", "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion("Moody", "Reading").getSuggestionName());
        }
        if (moodTitle.equals("Relaxed"))
        {
            musicSuggestion.setSuggestionName(db.getSuggestion("Relaxed", "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion("Relaxed", "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion("Relaxed", "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion("Relaxed", "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion("Relaxed", "Reading").getSuggestionName());
        }

        ImageButton btnRandom = findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list.remove(musicSuggestion);
                list.remove(sportSuggestion);
                list.remove(outDoorSuggestion);
                list.remove(gameSuggestion);
                list.remove(poetrySuggestion);

                if (moodTitle.equals("Calmer")) {
                    musicSuggestion.setSuggestionName(db.getSuggestion("Calmer", "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion("Calmer", "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion("Calmer", "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion("Calmer", "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion("Calmer", "Reading").getSuggestionName());
                }
                if (moodTitle.equals("Energetic"))
                {
                    musicSuggestion.setSuggestionName(db.getSuggestion("Energetic", "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion("Energetic", "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion("Energetic", "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion("Energetic", "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion("Energetic", "Reading").getSuggestionName());
                }
                if (moodTitle.equals("Happier"))
                {
                    musicSuggestion.setSuggestionName(db.getSuggestion("Happier", "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion("Happier", "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion("Happier", "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion("Happier", "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion("Happier", "Reading").getSuggestionName());
                }
                if (moodTitle.equals("Moody"))
                {
                    musicSuggestion.setSuggestionName(db.getSuggestion("Moody", "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion("Moody", "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion("Moody", "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion("Moody", "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion("Moody", "Reading").getSuggestionName());
                }
                if (moodTitle.equals("Relaxed"))
                {
                    musicSuggestion.setSuggestionName(db.getSuggestion("Relaxed", "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion("Relaxed", "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion("Relaxed", "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion("Relaxed", "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion("Relaxed", "Reading").getSuggestionName());
                }

                list.add(musicSuggestion);
                list.add(sportSuggestion);
                list.add(outDoorSuggestion);
                list.add(gameSuggestion);
                list.add(poetrySuggestion);

                ArrayAdapter<Suggestion> adapter = new SuggestionArrayAdapter(SuggestionsActivity.this,
                        R.layout.row_layout_suggestions, R.id.lblCategory, R.id.lblSuggestion, list);

                setListAdapter(adapter);
            }
        });

        list.add(musicSuggestion);
        list.add(sportSuggestion);
        list.add(outDoorSuggestion);
        list.add(gameSuggestion);
        list.add(poetrySuggestion);

        ArrayAdapter<Suggestion> adapter = new SuggestionArrayAdapter(this,
                R.layout.row_layout_suggestions, R.id.lblCategory, R.id.lblSuggestion, list);

        setListAdapter(adapter);
    }

    // Open the Map Page
    private void openMap(){
        Intent start = new Intent(getApplicationContext(), MapActivity.class);
        startActivity(start);
    }
}