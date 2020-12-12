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

public class SuggestionsActivitySad extends ListActivity {

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

        final Suggestion musicSuggestion = new Suggestion ("Music", "Summertime Sadness - Lana Del Rey");
        final Suggestion sportSuggestion = new Suggestion ("Sport", "Walk in park");
        final Suggestion outDoorSuggestion = new Suggestion("Outdoors", "Go outside and buy something for yourself");
        final Suggestion gameSuggestion = new Suggestion ("Games", "Chess");
        final Suggestion poetrySuggestion = new Suggestion ("Reading",
                "There are two sides on every coin,\n" +
                                "The heads and the tails.\n" +
                                 "So must it be with all in this life,\n" +
                                "Duality and perfect balance, all entails.");

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