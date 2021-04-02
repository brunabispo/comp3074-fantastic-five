package ca.gbc.comp3074.mind_manager_app.Admin;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.sql.Connection;
import java.util.List;
import ca.gbc.comp3074.mind_manager_app.GoogleMySQLConnectionHelper;
import ca.gbc.comp3074.mind_manager_app.MainActivity;
import ca.gbc.comp3074.mind_manager_app.Models.AdminSuggestionArrayAdapter;
import ca.gbc.comp3074.mind_manager_app.Models.Suggestion;
import ca.gbc.comp3074.mind_manager_app.R;

public class AdminSuggestionsActivity extends ListActivity {

    List<Suggestion> suggestions;
    String categoryTitle = "";
    String moodTitle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_suggestions);

        //accept variables "Category" and "Mood" from Admin Moods for Category page
        TextView title = findViewById(R.id.lblTitleSuggestionsForCategory);
        Intent intent = getIntent();
        categoryTitle = intent.getStringExtra("category");
        moodTitle = intent.getStringExtra("mood");
        title.setText("Category: " + categoryTitle + "\n Mood: " + moodTitle);

        //Database instance
        final GoogleMySQLConnectionHelper db = new GoogleMySQLConnectionHelper();
        final Connection connect = db.connectionclass();

        printArray(connect, db);

        //button add Suggestion
        Button btnAddNewSuggestion = findViewById(R.id.btnAddSuggestion);
        btnAddNewSuggestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewSuggestion();
            }
        });

        //button Logout
        Button btnLogOut = findViewById(R.id.btnLogoutAdmin);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogOut();
            }
        });
    }

    //print array of all questions
    private void printArray(Connection connect, GoogleMySQLConnectionHelper db){
        suggestions = db.getAllSuggestionsOneCategoryOneMood(connect, moodTitle, categoryTitle);
        StringBuilder sb = new StringBuilder();
        int size = suggestions.size();
        boolean appendSeparator = false;
        for(int y=0; y < size; y++){
            if (appendSeparator)
                sb.append(','); // a comma
            appendSeparator = true;
            sb.append(suggestions.get(y));
        }
        ArrayAdapter<Suggestion> myAdapter = new AdminSuggestionArrayAdapter(this, suggestions);
        setListAdapter(myAdapter);
    }

    //function to start AdminAddNewSuggestionActivity
    private void addNewSuggestion(){
        Intent start = new Intent(getApplicationContext(), AdminAddNewQuestionActivity.class);
        startActivity(start);
    }

    //function LogOut
    private void openLogOut(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }
}