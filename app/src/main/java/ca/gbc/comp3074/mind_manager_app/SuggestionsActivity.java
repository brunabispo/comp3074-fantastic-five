package ca.gbc.comp3074.mind_manager_app;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SuggestionsActivity extends ListActivity {

    List<Suggestion> list; // List of suggestions

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        list = new ArrayList<Suggestion>();
        list.add(new Suggestion("Music", "Playlist"));
        list.add(new Suggestion("Poetry", "1 poem"));
        list.add(new Suggestion("Sport", "1 sport"));
        list.add(new Suggestion("Outside Activity", "1 outside activity"));

        ArrayAdapter<Suggestion> adapter = new SuggestionArrayAdapter(this,
                R.layout.row_layout_suggestions, R.id.lblCategory, R.id.lblSuggestion, list);

        setListAdapter(adapter);
    }
}
