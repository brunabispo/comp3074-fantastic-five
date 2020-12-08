package ca.gbc.comp3074.mind_manager_app;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class SuggestionsActivityEnergetic extends ListActivity {

    List<Suggestion> list; // List of suggestions

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        list = new ArrayList<Suggestion>();

//        // Get a Realm instance for this thread
//        final Realm realm = Realm.getDefaultInstance();

//        //Query looking for all suggestions
//        final RealmQuery<Suggestion> suggestions =  realm.where(Suggestion.class);

//        realm.beginTransaction();
        final Suggestion musicSuggestion = new Suggestion ("Music", "Play Hard - David Guetta");
        final Suggestion sportSuggestion = new Suggestion ("Sport", "Lazer-Tag");
        final Suggestion outDoorSuggestion = new Suggestion("Outdoors", "Go for a Run");
        final Suggestion gameSuggestion = new Suggestion ("Games", "Just Dance");
        final Suggestion poetrySuggestion = new Suggestion ("Reading", "Hunger Games");
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
