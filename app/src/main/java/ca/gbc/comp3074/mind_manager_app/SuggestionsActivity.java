package ca.gbc.comp3074.mind_manager_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.RequestQueue;
import java.util.ArrayList;
//import com.google.android.gms.common.api.Response;
import java.sql.Connection;
import ca.gbc.comp3074.mind_manager_app.Movies.MovieMain;
import ca.gbc.comp3074.mind_manager_app.Reading.BookInfo;
import ca.gbc.comp3074.mind_manager_app.Models.Suggestion;
import ca.gbc.comp3074.mind_manager_app.Models.SuggestionArrayAdapter;
import ca.gbc.comp3074.mind_manager_app.Music.VideoMain;
import ca.gbc.comp3074.mind_manager_app.Reading.BookDisplayActivity;
import ca.gbc.comp3074.mind_manager_app.Games.CrosswordGameActivity;

public class SuggestionsActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Suggestion> categories;
    ArrayList<Suggestion> suggestions = new ArrayList<>();
    private RequestQueue mRequestQueue; ///////////added
    private ArrayList<BookInfo> bookInfoArrayList; /////////////added

    int[] images = {R.drawable.sports, R.drawable.outdoors, R.drawable.reading, R.drawable.music, R.drawable.movies, R.drawable.games};

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        listView = findViewById(R.id.listView);

        TextView title = findViewById(R.id.lblTitle);
        Intent intent = getIntent();
        final String moodTitle = intent.getStringExtra("Mood");
        title.setText("Here are your suggestions for being more " + moodTitle);

        //Database instance
        final GoogleMySQLConnectionHelper db = new GoogleMySQLConnectionHelper();
        final Connection connect = db.connectionclass();

        categories = db.getAllCategories(connect);

        ImageButton btnMap = findViewById(R.id.btn_map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        getSetOfDifferentSuggestions(connect, moodTitle, db);

        SuggestionArrayAdapter adapter = new SuggestionArrayAdapter(this, suggestions, images);
        listView.setAdapter(adapter);

        //functionality for btnFilter
        ImageButton btnFilter = findViewById(R.id.btnFilter);
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suggestions.clear();
                categories.clear();
                categories.add(0, new Suggestion("Music"));
                suggestions = db.getSetOfSuggestionsFromOneCategory(connect, moodTitle, "Music");

                SuggestionArrayAdapter adapter = new SuggestionArrayAdapter(SuggestionsActivity.this, suggestions, images);
                listView.setAdapter(adapter);
            }
        });

        //functionality for btnRandom
        ImageButton btnRandom = findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suggestions.clear();
                categories.clear();
                categories = db.getAllCategories(connect);
                getSetOfDifferentSuggestions(connect, moodTitle, db);

                SuggestionArrayAdapter adapter = new SuggestionArrayAdapter(SuggestionsActivity.this, suggestions, images);
                listView.setAdapter(adapter);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (suggestions.get(position).getCategoryName().equals("Sport")){
                    Intent start = new Intent(getApplicationContext(), QuestionsActivity.class);
                    startActivity(start);
                }
                if (suggestions.get(position).getCategoryName().equals("Outdoors")){
                    Intent start = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(start);
                }
                if (suggestions.get(position).getCategoryName().equals("Reading")){
                    Intent start = new Intent(getApplicationContext(), BookDisplayActivity.class);
                    start.putExtra("bookTitle", suggestions.get(position).getSuggestionName());
                    startActivity(start);
                }
                if (suggestions.get(position).getCategoryName().equals("Music")){
                    Intent start = new Intent(SuggestionsActivity.this, VideoMain.class);
                    start.putExtra("MyParameter", suggestions.get(position).getYoutubeLink());
                    startActivity(start);
                }
                if (suggestions.get(position).getCategoryName().equals("Movie")){
                    Intent start = new Intent(SuggestionsActivity.this, MovieMain.class);
                    start.putExtra("MyParameter1", suggestions.get(position).getYoutubeLink());
                    startActivity(start);
                }
                if (suggestions.get(position).getCategoryName().equals("Games")){
                    Intent start = new Intent(getApplicationContext(), CrosswordGameActivity.class);
                    start.putExtra("Mood", moodTitle);
                    startActivity(start);
                }
            }
        });
    }

    private void getSetOfDifferentSuggestions(Connection connect, String moodTitle, GoogleMySQLConnectionHelper db){
        for(int i=0; i<6; i++){
            Suggestion suggestion = db.getSuggestion(connect, moodTitle, categories.get(i).getCategoryName()+"");
            suggestions.add(suggestion);
        }
    }

    // Open the Map Page
    private void openMap(){
        Intent start = new Intent(getApplicationContext(), MapActivity.class);
        startActivity(start);
    }
}