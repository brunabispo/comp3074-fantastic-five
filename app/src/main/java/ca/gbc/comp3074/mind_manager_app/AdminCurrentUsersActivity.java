package ca.gbc.comp3074.mind_manager_app;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class AdminCurrentUsersActivity extends ListActivity {

    List<User> users;
    TextView lblError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_current_users);

        lblError = findViewById(R.id.lblError2);

        //Database instance
        final GoogleMySQLConnectionHelper db = new GoogleMySQLConnectionHelper();

        printArray(db);

        //button add User
        Button btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdd(db);
            }
        });

        //button Logout
        Button btnLogOut = findViewById(R.id.btnLogoutAdminCurrentUsers);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogOut();
            }
        });
    }

    //delete User
    protected void onListItemClick(ListView l, View v, int position, long id, GoogleMySQLConnectionHelper db) {
        super.onListItemClick(l, v, position, id);
        db.deleteUser(position);
        printArray(db);
    }

    //print array of all users
    private void printArray(GoogleMySQLConnectionHelper db){
        users = db.getAllUsers();
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
    }

    //function add User
    private void openAdd(GoogleMySQLConnectionHelper db){
        String role = ((EditText) findViewById(R.id.edittxt_role)).getText().toString();
        String username = ((EditText) findViewById(R.id.edittxt_username)).getText().toString();
        String firstName = ((EditText) findViewById(R.id.edittxt_firstName)).getText().toString();
        //Execute the query, find if username input is existing in data base
        User userExist = db.getUser(username);

        if(userExist != null){
            lblError.setText("This user name is already exist");
        }else {
            lblError.setText("");
            //Insert new user
            User user = new User(role, username, firstName, "123_Ben");
            db.addUser(user);
            printArray(db);
        }
    }

    //function LogOut
    private void openLogOut(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }
}