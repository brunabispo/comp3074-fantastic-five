package ca.gbc.comp3074.mind_manager_app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AdminCurrentUsersActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin_current_users);

        //Database instance
        final GoogleMySQLConnectionHelper db = new GoogleMySQLConnectionHelper();

        List<User> users = db.getAllUsers();

        StringBuilder sb = new StringBuilder();
        int size = users.size();
        boolean appendSeparator = false;
        for(int y=0; y < size; y++){
            if (appendSeparator)
                sb.append(','); // a comma
            appendSeparator = true;
            sb.append(users.get(y));
        }

        ArrayAdapter<User> myAdapter = new UserArrayAdapter(this, users);
        setListAdapter(myAdapter);

        //button add User
        Button btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdd();
            }
        });

        Button btnLogOut = findViewById(R.id.btnLogoutAdminCurrentUsers);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogOut();
            }
        });
    }

    @Override
    //delete Item
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //list.remove(getListView().getItemAtPosition(position));
        //ArrayAdapter<Item> myAdapter = new MyArrayAdapter(this, list);
        //setListAdapter(myAdapter);
    }

    //function add Item
    private void openAdd(){
        String addName = ((EditText) findViewById(R.id.edittxt_name)).getText().toString();
        String addMeasuring = ((EditText) findViewById(R.id.edittxt_measuring)).getText().toString();
        //list.add(new Item(addName, addMeasuring, android.R.drawable.ic_delete));
        //ArrayAdapter<Item> myAdapter = new MyArrayAdapter(this, list);
        //setListAdapter(myAdapter);
    }

    private void openLogOut(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }
}