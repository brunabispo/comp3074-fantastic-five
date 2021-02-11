package ca.gbc.comp3074.mind_manager_app;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SuggestionsActivity extends ListActivity {

    List<Suggestion> list; // List of suggestions

    @SuppressLint("SetTextI18n")
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

        TextView title = findViewById(R.id.lblTitle);
        Intent intent = getIntent();
        final String moodTitle = intent.getStringExtra("Mood");
        title.setText("Here are your suggestions for " + moodTitle);

        list = new ArrayList<Suggestion>();

        final Suggestion musicSuggestion = new Suggestion();
        final Suggestion sportSuggestion = new Suggestion();
        final Suggestion outDoorSuggestion = new Suggestion();
        final Suggestion gameSuggestion = new Suggestion();
        final Suggestion poetrySuggestion = new Suggestion();
        musicSuggestion.setCategoryName("Music");
        sportSuggestion.setCategoryName("Sport");
        outDoorSuggestion.setCategoryName("Outdoors");
        gameSuggestion.setCategoryName("Games");
        poetrySuggestion.setCategoryName("Reading");

        if (moodTitle.equals("Calmer")) {
            musicSuggestion.setSuggestionName("Lemon Tree - Fools Garden");
            sportSuggestion.setSuggestionName("Yoga");
            outDoorSuggestion.setSuggestionName("Go for fishing");
            gameSuggestion.setSuggestionName("Bubble shooter");
            poetrySuggestion.setSuggestionName("Of all bodily functions that could be contagious, thank God it's THE YAWN - Unknown");
        }
        if (moodTitle.equals("Energetic"))
        {
            musicSuggestion.setSuggestionName("Play Hard - David Guetta");
            sportSuggestion.setSuggestionName("Lazer-Tag");
            outDoorSuggestion.setSuggestionName("Go for a Run");
            gameSuggestion.setSuggestionName("Just Dance");
            poetrySuggestion.setSuggestionName("Hunger Games");
        }
        if (moodTitle.equals("Happier"))
        {
            musicSuggestion.setSuggestionName("I Feel Good - James Brown");
            sportSuggestion.setSuggestionName("Paint-Ball");
            outDoorSuggestion.setSuggestionName("Meet with friends");
            gameSuggestion.setSuggestionName("Fortnight");
            poetrySuggestion.setSuggestionName("Diary of a Wimpy Kid");
        }
        if (moodTitle.equals("Moody"))
        {
            musicSuggestion.setSuggestionName("Summertime Sadness - Lana Del Rey");
            sportSuggestion.setSuggestionName("Walk in park");
            outDoorSuggestion.setSuggestionName("Go outside and buy something for yourself");
            gameSuggestion.setSuggestionName("Chess");
            poetrySuggestion.setSuggestionName("There are two sides on every coin,\n" +
                                "The heads and the tails.\n" +
                                "So must it be with all in this life,\n" +
                                "Duality and perfect balance, all entails.");
        }
        if (moodTitle.equals("Tired"))
        {
            musicSuggestion.setSuggestionName("Weightless - Macaroni Uniony");
            sportSuggestion.setSuggestionName("None");
            outDoorSuggestion.setSuggestionName("Massage therapy");
            gameSuggestion.setSuggestionName("Monopoly One");
            poetrySuggestion.setSuggestionName("Time says “Let there be”\n" +
                                "every moment and instantly\n" +
                                "there is space and the radiance\n" +
                                "of each bright galaxy.");
        }

        ImageButton btnRandom = findViewById(R.id.btnRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list.remove(musicSuggestion);
                list.remove(sportSuggestion);
                list.remove(outDoorSuggestion);
                list.remove(gameSuggestion);
                list.remove(poetrySuggestion);

                if (moodTitle.equals("Calmer")) {
                    musicSuggestion.setSuggestionName("Lost & Found - MacKenzie Bourg");
                    sportSuggestion.setSuggestionName("Swimming");
                    outDoorSuggestion.setSuggestionName("Ride a Bike");
                    gameSuggestion.setSuggestionName("Tetris");
                    poetrySuggestion.setSuggestionName("Of all bodily functions that could be contagious, " +
                            "thank God it's THE YAWN - Unknown");
                }
                if (moodTitle.equals("Energetic"))
                {
                    musicSuggestion.setSuggestionName("Don't Say Goodbye - Alok");
                    sportSuggestion.setSuggestionName("Running");
                    outDoorSuggestion.setSuggestionName("Paint-ball");
                    gameSuggestion.setSuggestionName("Hide and Seek");
                    poetrySuggestion.setSuggestionName("Harry Potter and The Goblet of Fire");
                }
                if (moodTitle.equals("Happier"))
                {
                    musicSuggestion.setSuggestionName("Who's Laughing Now - Ava Max");
                    sportSuggestion.setSuggestionName("Laser Tag");
                    outDoorSuggestion.setSuggestionName("Go to the park");
                    gameSuggestion.setSuggestionName("UNO");
                    poetrySuggestion.setSuggestionName("Happiness is a direction, not a place.");
                }
                if (moodTitle.equals("Moody"))
                {
                    musicSuggestion.setSuggestionName("Exile - Taylor Swift");
                    sportSuggestion.setSuggestionName("Swimming");
                    outDoorSuggestion.setSuggestionName("Walk in the park");
                    gameSuggestion.setSuggestionName("The Sims");
                    poetrySuggestion.setSuggestionName("The Fault in Our Starts - John Green");
                }
                if (moodTitle.equals("Tired"))
                {
                    musicSuggestion.setSuggestionName("Broken Hands of Mine - Joe Brooks");
                    sportSuggestion.setSuggestionName("Yoga");
                    outDoorSuggestion.setSuggestionName("Sit on a bench in the park");
                    gameSuggestion.setSuggestionName("Bubble Shooter");
                    poetrySuggestion.setSuggestionName("Well God knows my feet, they aching\n" +
                            "And I've got a mountains ahead to climb\n" +
                            "One way at a time\n" +
                            "I will try\n" +
                            "To let these broken hands of mine\n" +
                            "Give me strength, be my light... - Broken Hands of Mine");
                }

                list.add(musicSuggestion);
                list.add(sportSuggestion);
                list.add(outDoorSuggestion);
                list.add(gameSuggestion);
                list.add(poetrySuggestion);

                ArrayAdapter<Suggestion> adapter = new SuggestionArrayAdapter(SuggestionsActivity.this,
                        R.layout.row_layout_suggestions, R.id.lblCategory, R.id.lblSuggestion, list);

                setListAdapter(adapter);
            }
        });

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