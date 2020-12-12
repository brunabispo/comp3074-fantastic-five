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

public class SuggestionsActivityHappy extends ListActivity {

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

        final Suggestion musicSuggestion = new Suggestion ("Music", "I Feel Good - James Brown");
        final Suggestion sportSuggestion = new Suggestion ("Sport", "Paint-Ball");
        final Suggestion outDoorSuggestion = new Suggestion("Outdoors", "Meet with friends");
        final Suggestion gameSuggestion = new Suggestion ("Games", "Fortnight");
        final Suggestion poetrySuggestion = new Suggestion ("Reading", "Diary of a Wimpy Kid");

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

                final Suggestion musicSuggestion1 = new Suggestion ("Music", "Who's Laughing Now - Ava Max");
                final Suggestion sportSuggestion1 = new Suggestion ("Sport", "Laser Tag");
                final Suggestion outDoorSuggestion1 = new Suggestion("Outdoors", "Go to the park");
                final Suggestion gameSuggestion1 = new Suggestion ("Games", "UNO");
                final Suggestion poetrySuggestion1 = new Suggestion ("Reading", "Happiness is a direction, not a place.");

                list.add(musicSuggestion1);
                list.add(sportSuggestion1);
                list.add(outDoorSuggestion1);
                list.add(gameSuggestion1);
                list.add(poetrySuggestion1);

                ArrayAdapter<Suggestion> adapter = new SuggestionArrayAdapter(SuggestionsActivityHappy.this,
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