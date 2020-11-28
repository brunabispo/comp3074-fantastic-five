package ca.gbc.comp3074.mind_manager_app;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;

public class SuggestionsActivity extends ListActivity {

    List<Suggestion> list; // List of suggestions

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        list = new ArrayList<Suggestion>();

        // Get a Realm instance for this thread
        final Realm realm = Realm.getDefaultInstance();

        //Query looking for all users
        final RealmQuery<Suggestion> suggestions =  realm.where(Suggestion.class);

        realm.beginTransaction();
        final Suggestion musicSuggestion = new Suggestion ("Music", "feel good");
        final Suggestion sportSuggestion = new Suggestion ("Sport", "push-ups");

        //Write in data base
        realm.copyToRealm(musicSuggestion);
        realm.copyToRealm(sportSuggestion);
        realm.commitTransaction();

        list.add(musicSuggestion);
        list.add(sportSuggestion);

        ArrayAdapter<Suggestion> adapter = new SuggestionArrayAdapter(this,
                R.layout.row_layout_suggestions, R.id.lblCategory, R.id.lblSuggestion, list);

        setListAdapter(adapter);
    }
}
