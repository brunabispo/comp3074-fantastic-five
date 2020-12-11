package ca.gbc.comp3074.mind_manager_app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class SuggestionsActivitySad extends ListActivity {

    List<Suggestion> list; // List of suggestions

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        list = new ArrayList<Suggestion>();

        /*
        ImageButton btnMap = findViewById(R.id.btn_map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });
        */

//        // Get a Realm instance for this thread
//        final Realm realm = Realm.getDefaultInstance();

//        //Query looking for all suggestions
//        final RealmQuery<Suggestion> suggestions =  realm.where(Suggestion.class);

//        realm.beginTransaction();
        final Suggestion musicSuggestion = new Suggestion ("Music", "Summertime Sadness - Lana Del Rey");
        final Suggestion sportSuggestion = new Suggestion ("Sport", "Walk in park");
        final Suggestion outDoorSuggestion = new Suggestion("Outdoors", "Go outside and buy something for yourself");
        final Suggestion gameSuggestion = new Suggestion ("Games", "Chess");
        final Suggestion poetrySuggestion = new Suggestion ("Reading",
                "There are two sides on every coin,\n" +
                                "The heads and the tails.\n" +
                                 "So must it be with all in this life,\n" +
                                "Duality and perfect balance, all entails.");
//        //Write in data base
//        realm.copyToRealm(musicSuggestion);
//        realm.copyToRealm(sportSuggestion);
//        realm.commitTransaction();

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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Logic to still be implemented
        switch(view.getId()) {
            case R.id.rbtn_q1_1:
                if (checked)  {
                    ArrayAdapter<Suggestion> adapter = new SuggestionArrayAdapter(this,
                            R.layout.row_layout_suggestions, R.id.lblCategory, R.id.lblSuggestion, list);

                    setListAdapter(adapter);
                }
                    break;
            case R.id.rbtn_q2_1:
                break;

            case R.id.rbtn_q3_1:
                break;

            case R.id.rbtn_q4_1:
                break;

        }
    }
}
