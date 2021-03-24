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
import ca.gbc.comp3074.mind_manager_app.Games.CrosswordGameActivity;
import ca.gbc.comp3074.mind_manager_app.Games.TriviaGameActivity;
import ca.gbc.comp3074.mind_manager_app.Models.BookDetails;
import ca.gbc.comp3074.mind_manager_app.Models.BookInfo;
import ca.gbc.comp3074.mind_manager_app.Models.Suggestion;
import ca.gbc.comp3074.mind_manager_app.Models.SuggestionArrayAdapter;

public class SuggestionsActivity extends AppCompatActivity {

    ListView listView;
    private RequestQueue mRequestQueue; ///////////added
    private ArrayList<BookInfo> bookInfoArrayList; /////////////added
    String musicPlayer = "";
    final Suggestion musicSuggestion = new Suggestion();
    final Suggestion sportSuggestion = new Suggestion();
    final Suggestion outDoorSuggestion = new Suggestion();
    final Suggestion gameSuggestion = new Suggestion();
    final Suggestion poetrySuggestion = new Suggestion();

    String categoriesTitle[] = {musicSuggestion.getCategoryName(), sportSuggestion.getCategoryName(),
            outDoorSuggestion.getCategoryName(), gameSuggestion.getCategoryName(), poetrySuggestion.getCategoryName()};

    String suggestionsName[] = {musicSuggestion.getSuggestionName(), sportSuggestion.getSuggestionName(),
        outDoorSuggestion.getSuggestionName(), gameSuggestion.getSuggestionName(), poetrySuggestion.getSuggestionName()};

    int images[] = {R.drawable.music, R.drawable.sports, R.drawable.outdoors, R.drawable.games, R.drawable.reading};

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

        listView = findViewById(R.id.listView);
        final ArrayList<Suggestion> suggestions = new ArrayList<>();

        TextView title = findViewById(R.id.lblTitle);
        Intent intent = getIntent();
        final String moodTitle = intent.getStringExtra("Mood");

        title.setText("Here are your suggestions for being more " + moodTitle);

        //Database instance
        final GoogleMySQLConnectionHelper db = new GoogleMySQLConnectionHelper();
        final Connection connect = db.connectionclass();

        if (moodTitle.equals("Calmer")) {
            musicPlayer= db.getSuggestion(connect, moodTitle, "Music").getSuggestionName();
            musicPlayer= db.getSuggestion(connect, moodTitle, "Music").getSuggestionName();
            musicSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
        }

        if (moodTitle.equals("Energetic")) {
            musicSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
        }

        if (moodTitle.equals("Happier")) {
            musicSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
        }

        if (moodTitle.equals("Moody")) {
            musicSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
        }

        if (moodTitle.equals("Relaxed")) {
            musicSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Music").getSuggestionName());
            sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
            outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
            gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
            poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
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

                if (moodTitle.equals("Calmer")) {
                    musicPlayer= db.getSuggestion(connect, moodTitle, "Music").getSuggestionName();
                    musicSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
                }

                if (moodTitle.equals("Energetic")) {
                    musicSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
                }

                if (moodTitle.equals("Happier")) {
                    musicSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
                }

                if (moodTitle.equals("Moody")) {
                    musicSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
                }

                if (moodTitle.equals("Relaxed")) {
                    musicSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Music").getSuggestionName());
                    sportSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Sport").getSuggestionName());
                    outDoorSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Outdoors").getSuggestionName());
                    gameSuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Games").getSuggestionName());
                    poetrySuggestion.setSuggestionName(db.getSuggestion(connect, moodTitle, "Reading").getSuggestionName());
                }
            }
        });

        suggestions.add(musicSuggestion);
        suggestions.add(sportSuggestion);
        suggestions.add(outDoorSuggestion);
        suggestions.add(gameSuggestion);
        suggestions.add(poetrySuggestion);

        SuggestionArrayAdapter adapter = new SuggestionArrayAdapter(this,R.layout.row_layout_suggestions, suggestions, images);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Intent start1 = new Intent(SuggestionsActivity.this, VideoMain.class);
                    //start.putExtra("selection",selection);
                    start1.putExtra("musicPlayer", musicPlayer);
                    startActivity(start1);
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
            }
        });
        ImageButton btnMap = findViewById(R.id.btn_map);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openMap();
            }
        });
    }

    // Open the Map Page
    private void openMap(){
        Intent start = new Intent(getApplicationContext(), MapActivity.class);
        startActivity(start);
    }
}