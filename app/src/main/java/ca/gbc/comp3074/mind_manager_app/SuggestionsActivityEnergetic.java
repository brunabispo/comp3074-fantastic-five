package ca.gbc.comp3074.mind_manager_app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RadioButton;
import java.util.ArrayList;
import java.util.List;

public class SuggestionsActivityEnergetic extends ListActivity {

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

        final Suggestion musicSuggestion = new Suggestion ("Music", "Play Hard - David Guetta");
        final Suggestion sportSuggestion = new Suggestion ("Sport", "Lazer-Tag");
        final Suggestion outDoorSuggestion = new Suggestion("Outdoors", "Go for a Run");
        final Suggestion gameSuggestion = new Suggestion ("Games", "Just Dance");
        final Suggestion poetrySuggestion = new Suggestion ("Reading", "Hunger Games");

        list.add(musicSuggestion);
        list.add(sportSuggestion);
        list.add(outDoorSuggestion);
        list.add(gameSuggestion);
        list.add(poetrySuggestion);

        ImageButton btnRandom = findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list.remove(musicSuggestion);
                list.remove(sportSuggestion);
                list.remove(outDoorSuggestion);
                list.remove(gameSuggestion);
                list.remove(poetrySuggestion);

                final Suggestion musicSuggestion1 = new Suggestion ("Music", "Don't Say Goodbye - Alok");
                final Suggestion sportSuggestion1 = new Suggestion ("Sport", "Running");
                final Suggestion outDoorSuggestion1 = new Suggestion("Outdoors", "Paint-ball");
                final Suggestion gameSuggestion1 = new Suggestion ("Games", "Hide and Seek");
                final Suggestion poetrySuggestion1 = new Suggestion ("Reading", "Harry Potter and The Goblet of Fire");

                list.add(musicSuggestion1);
                list.add(sportSuggestion1);
                list.add(outDoorSuggestion1);
                list.add(gameSuggestion1);
                list.add(poetrySuggestion1);

                ArrayAdapter<Suggestion> adapter = new SuggestionArrayAdapter(SuggestionsActivityEnergetic.this,
                        R.layout.row_layout_suggestions, R.id.lblCategory, R.id.lblSuggestion, list);

                setListAdapter(adapter);

            }
        });

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