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
import ca.gbc.comp3074.mind_manager_app.Games.TriviaGameActivity;
import ca.gbc.comp3074.mind_manager_app.Reading.BookInfo;
import ca.gbc.comp3074.mind_manager_app.Models.Suggestion;
import ca.gbc.comp3074.mind_manager_app.Models.SuggestionArrayAdapter;
import ca.gbc.comp3074.mind_manager_app.Music.VideoMain;
import ca.gbc.comp3074.mind_manager_app.Reading.BookDisplayActivity;

public class SuggestionsActivity extends AppCompatActivity {

    ListView listView;
    private RequestQueue mRequestQueue; ///////////added
    private ArrayList<BookInfo> bookInfoArrayList; /////////////added
    String title1 = "";
    String musicVideo = "";
    Suggestion musicSuggestion = new Suggestion();
    Suggestion sportSuggestion = new Suggestion();
    Suggestion outDoorSuggestion = new Suggestion();
    Suggestion gameSuggestion = new Suggestion();
    Suggestion poetrySuggestion = new Suggestion();
    Suggestion movieSuggestion = new Suggestion();

    int images[] = {R.drawable.music, R.drawable.sports, R.drawable.outdoors, R.drawable.games, R.drawable.reading, R.drawable.movies};

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);
        musicSuggestion.setCategoryName("Music");
        sportSuggestion.setCategoryName("Sport");
        outDoorSuggestion.setCategoryName("Outdoors");
        gameSuggestion.setCategoryName("Games");
        poetrySuggestion.setCategoryName("Reading");
        movieSuggestion.setCategoryName("Movie");

        listView = findViewById(R.id.listView);
        final ArrayList<Suggestion> suggestions = new ArrayList<>();

        TextView title = findViewById(R.id.lblTitle);
        Intent intent = getIntent();
        final String moodTitle = intent.getStringExtra("Mood");

        title.setText("Here are your suggestions for being more " + moodTitle);
        //Database instance
        final GoogleMySQLConnectionHelper db = new GoogleMySQLConnectionHelper();
        final Connection connect = db.connectionclass();

        ImageButton btnMap = findViewById(R.id.btn_map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        if (moodTitle.equals("Calmer")) {
            Suggestion music = db.getSuggestion(connect, moodTitle, "Music");
            musicVideo= music.getYoutubeLink();
            musicSuggestion.setSuggestionName(music.getSuggestionName());
            musicSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
            movieSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Movie").getSuggestionName());
        }

        if (moodTitle.equals("Energetic")) {
            Suggestion music = db.getSuggestion(connect, moodTitle, "Music");
            musicVideo= music.getYoutubeLink();
            musicSuggestion.setSuggestionName(music.getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
            movieSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Movie").getSuggestionName());
        }

        if (moodTitle.equals("Happier")) {
            Suggestion music = db.getSuggestion(connect, moodTitle, "Music");
            musicVideo= music.getYoutubeLink();
            musicSuggestion.setSuggestionName(music.getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
            movieSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Movie").getSuggestionName());
        }

        if (moodTitle.equals("Moody")) {
            Suggestion music = db.getSuggestion(connect, moodTitle, "Music");
            musicVideo= music.getYoutubeLink();
            musicSuggestion.setSuggestionName(music.getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
            movieSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Movie").getSuggestionName());
        }

        if (moodTitle.equals("Relaxed")) {
            Suggestion music = db.getSuggestion(connect, moodTitle, "Music");
            musicVideo= music.getYoutubeLink();
            musicSuggestion.setSuggestionName(music.getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
            movieSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Movie").getSuggestionName());
        }

        //functionality for btnRandom
        ImageButton btnRandom = findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suggestions.remove(musicSuggestion);
                suggestions.remove(sportSuggestion);
                suggestions.remove(outDoorSuggestion);
                suggestions.remove(gameSuggestion);
                suggestions.remove(poetrySuggestion);
                suggestions.remove(movieSuggestion);

                if (moodTitle.equals("Calmer")) {
                    Suggestion music = db.getSuggestion(connect, moodTitle, "Music");
                    musicVideo= music.getYoutubeLink();
                    musicSuggestion.setSuggestionName(music.getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
                    movieSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Movie").getSuggestionName());
                }

                if (moodTitle.equals("Energetic")) {
                    Suggestion music = db.getSuggestion(connect, moodTitle, "Music");
                    musicVideo= music.getYoutubeLink();
                    musicSuggestion.setSuggestionName(music.getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
                    movieSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Movie").getSuggestionName());
                }

                if (moodTitle.equals("Happier")) {
                    Suggestion music = db.getSuggestion(connect, moodTitle, "Music");
                    musicVideo= music.getYoutubeLink();
                    musicSuggestion.setSuggestionName(music.getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
                    movieSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Movie").getSuggestionName());
                }

                if (moodTitle.equals("Moody")) {
                    Suggestion music = db.getSuggestion(connect, moodTitle, "Music");
                    musicVideo= music.getYoutubeLink();
                    musicSuggestion.setSuggestionName(music.getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
                    movieSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Movie").getSuggestionName());
                }

                if (moodTitle.equals("Relaxed")) {
                    Suggestion music = db.getSuggestion(connect, moodTitle, "Music");
                    musicVideo= music.getYoutubeLink();
                    musicSuggestion.setSuggestionName(music.getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
                    movieSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Movie").getSuggestionName());
                }
                suggestions.add(musicSuggestion);
                suggestions.add(sportSuggestion);
                suggestions.add(outDoorSuggestion);
                suggestions.add(gameSuggestion);
                suggestions.add(poetrySuggestion);
                suggestions.add(movieSuggestion);

                SuggestionArrayAdapter adapter = new SuggestionArrayAdapter(SuggestionsActivity.this, suggestions, images);
                listView.setAdapter(adapter);
            }
        });

        suggestions.add(musicSuggestion);
        suggestions.add(sportSuggestion);
        suggestions.add(outDoorSuggestion);
        suggestions.add(gameSuggestion);
        suggestions.add(poetrySuggestion);
        suggestions.add(movieSuggestion);

        SuggestionArrayAdapter adapter = new SuggestionArrayAdapter(this, suggestions, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){

                    Intent i = new Intent(SuggestionsActivity.this, VideoMain.class);

                    i.putExtra("MyParameter", musicVideo);
                    startActivity(i);
                }
                if (position == 1){
                    Intent start = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(start);
                }
                if (position == 2){
                    Intent start = new Intent(getApplicationContext(), QuestionsActivity.class);
                    startActivity(start);
                }
                if (position == 3){
                    Intent start = new Intent(getApplicationContext(), TriviaGameActivity.class);
                    startActivity(start);
                }
                if (position == 4){
                    Intent start = new Intent(getApplicationContext(), BookDisplayActivity.class);
                    startActivity(start);
                }
                if (position == 5){
                    Intent start = new Intent(getApplicationContext(), BookDisplayActivity.class);
                    startActivity(start);
                }
            }
        });
    }

    // Open the Map Page
    private void openMap(){
        Intent start = new Intent(getApplicationContext(), MapActivity.class);
        startActivity(start);
    }
}