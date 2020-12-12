package ca.gbc.comp3074.mind_manager_app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import java.util.ArrayList;
import java.util.List;

public class SuggestionsActivityBored extends ListActivity {

    List<Suggestion> list; // List of suggestions

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

        list = new ArrayList<Suggestion>();


        final Suggestion musicSuggestion = new Suggestion ("Music", "Lemon Tree - Fools Garden");
        final Suggestion sportSuggestion = new Suggestion ("Sport", "Yoga");
        final Suggestion outDoorSuggestion = new Suggestion("Outdoors", "Go for fishing");
        final Suggestion gameSuggestion = new Suggestion ("Games", "Bubble shooter");
        final Suggestion poetrySuggestion = new Suggestion ("Reading", "Of all bodily functions that could be contagious, thank God it's THE YAWN - Unknown");

        ImageButton btnRandom = findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list.remove(musicSuggestion);
                list.remove(sportSuggestion);
                list.remove(outDoorSuggestion);
                list.remove(gameSuggestion);
                list.remove(poetrySuggestion);

                final Suggestion musicSuggestion1 = new Suggestion ("Music", "Lost & Found - MacKenzie Bourg");
                final Suggestion sportSuggestion1 = new Suggestion ("Sport", "Swimming");
                final Suggestion outDoorSuggestion1 = new Suggestion("Outdoors", "Ride a Bike");
                final Suggestion gameSuggestion1 = new Suggestion ("Games", "Tetris");
                final Suggestion poetrySuggestion1 = new Suggestion ("Reading", "Of all bodily functions that could be contagious, " +
                        "thank God it's THE YAWN - Unknown");

                list.add(musicSuggestion1);
                list.add(sportSuggestion1);
                list.add(outDoorSuggestion1);
                list.add(gameSuggestion1);
                list.add(poetrySuggestion1);

                ArrayAdapter<Suggestion> adapter = new SuggestionArrayAdapter(SuggestionsActivityBored.this,
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