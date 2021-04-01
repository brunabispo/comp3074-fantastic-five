package ca.gbc.comp3074.mind_manager_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.sql.Connection;
import ca.gbc.comp3074.mind_manager_app.Movies.MovieMain;
import ca.gbc.comp3074.mind_manager_app.Models.Suggestion;
import ca.gbc.comp3074.mind_manager_app.Models.SuggestionArrayAdapter;
import ca.gbc.comp3074.mind_manager_app.Music.VideoMain;
import ca.gbc.comp3074.mind_manager_app.Reading.BookDisplayActivity;
import ca.gbc.comp3074.mind_manager_app.Games.CrosswordGameActivity;

public class SuggestionsActivity extends AppCompatActivity{

    ListView listView;
    ArrayList<Suggestion> categories = new ArrayList<>();
    ArrayList<Suggestion> suggestions = new ArrayList<>();
    String moodTitle = "";
    String username = "";

    //Database instance
    final GoogleMySQLConnectionHelper db = new GoogleMySQLConnectionHelper();
    final Connection connect = db.connectionclass();

    //array of category images
    int[] images = {R.drawable.sports, R.drawable.outdoors, R.drawable.reading, R.drawable.music, R.drawable.movies, R.drawable.games};

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        listView = findViewById(R.id.listView);

        //accept variable "Mood" from Welcome page and set title of the current page
        TextView title = findViewById(R.id.lblTitle);
        Intent intent = getIntent();
        moodTitle = intent.getStringExtra("Mood");
        username = intent.getStringExtra("username");

        title.setText("Here are your suggestions for being more " + moodTitle);

        //functionality for btnFilter
        //create a list of items for the spinner (dropdown list for Filter button)
        Spinner dropdown = findViewById(R.id.spinner);
        final String[] items = new String[]{"All categories", "Sport", "Outdoors", "Reading", "Music", "Movie", "Games"};
        //set adapter for the spinner (dropdown list for Filter button)
        ArrayAdapter<String> spinerAdapter = new ArrayAdapter<String>(SuggestionsActivity.this, android.R.layout.simple_spinner_dropdown_item, items);
        spinerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(spinerAdapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                switch (items[position]) {
                    case "All categories":
                        //set suggestion to each unique category
                        getSetOfDifferentSuggestions(connect, moodTitle, db);
                        break;
                    case "Sport":
                        //add only one category (user choose it by Filter button)
                        categories.add(0, new Suggestion("Sport"));
                        //set 6 different suggestions for only one category and only one mood (by user choice)
                        suggestions = db.getSetOfSuggestionsFromOneCategory(connect, moodTitle, categories.get(0).getCategoryName()+"", username);
                        break;
                    case "Outdoors":
                        //add only one category (user choose it by Filter button)
                        categories.add(0, new Suggestion("Outdoors"));
                        //set 6 different suggestions for only one category and only one mood (by user choice)
                        suggestions = db.getSetOfSuggestionsFromOneCategory(connect, moodTitle, categories.get(0).getCategoryName()+"", username);
                        break;
                    case "Reading":
                        //add only one category (user choose it by Filter button)
                        categories.add(0, new Suggestion("Reading"));
                        //set 6 different suggestions for only one category and only one mood (by user choice)
                        suggestions = db.getSetOfSuggestionsFromOneCategory(connect, moodTitle, categories.get(0).getCategoryName()+"", username);
                        break;
                    case "Music":
                        //add only one category (user choose it by Filter button)
                        categories.add(0, new Suggestion("Music"));
                        //set 6 different suggestions for only one category and only one mood (by user choice)
                        suggestions = db.getSetOfSuggestionsFromOneCategory(connect, moodTitle, categories.get(0).getCategoryName()+"", username);
                        break;
                    case "Movie":
                        //add only one category (user choose it by Filter button)
                        categories.add(0, new Suggestion("Movie"));
                        //set 6 different suggestions for only one category and only one mood (by user choice)
                        suggestions = db.getSetOfSuggestionsFromOneCategory(connect, moodTitle, categories.get(0).getCategoryName()+"", username);
                        break;
                    default:
                        //add only one category (user choose it by Filter button)
                        categories.add(0, new Suggestion("Games"));
                        //set 6 different suggestions for only one category and only one mood (by user choice)
                        suggestions = db.getSetOfSuggestionsFromOneCategory(connect, moodTitle, categories.get(0).getCategoryName()+"", username);
                }

                //print result
                SuggestionArrayAdapter adapter = new SuggestionArrayAdapter(SuggestionsActivity.this, suggestions, images);
                listView.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        //functionality for btnMap
        ImageButton btnMap = findViewById(R.id.btn_map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        //functionality for btnRandom
        ImageButton btnRandom = findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set new suggestion to each unique category
                getSetOfDifferentSuggestions(connect, moodTitle, db);
                //print result
                SuggestionArrayAdapter adapter = new SuggestionArrayAdapter(SuggestionsActivity.this, suggestions, images);
                listView.setAdapter(adapter);
            }
        });

        //Move to next pages by clicking on any suggestion
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
                    String bookTitle = suggestions.get(position).getSuggestionName();
                    start.putExtra("bookTitle", bookTitle);
                    startActivity(start);
                }
                if (suggestions.get(position).getCategoryName().equals("Music")){
                    Intent start = new Intent(SuggestionsActivity.this, VideoMain.class);
                    String YoutubeLink = suggestions.get(position).getYoutubeLink();
                    start.putExtra("MyParameter", YoutubeLink);
                    startActivity(start);
                }
                if (suggestions.get(position).getCategoryName().equals("Movie")){
                    Intent start = new Intent(SuggestionsActivity.this, MovieMain.class);
                    String YoutubeLink = suggestions.get(position).getYoutubeLink();
                    start.putExtra("MyParameter1", YoutubeLink);
                    startActivity(start);
                }
                if (suggestions.get(position).getCategoryName().equals("Games")){
                    Intent start = new Intent(SuggestionsActivity.this, CrosswordGameActivity.class);
                    start.putExtra("game", moodTitle);
                    startActivity(start);
                }
            }
        });
    }

    // Receive set of 6 different suggestions for specific mood (it's function for Random button)
    private void getSetOfDifferentSuggestions(Connection connect, String moodTitle, GoogleMySQLConnectionHelper db){
        //delete all suggestions
        suggestions.clear();
        //find all unique categories
        categories = db.getAllCategories(connect);
        //set new suggestion to each unique category
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