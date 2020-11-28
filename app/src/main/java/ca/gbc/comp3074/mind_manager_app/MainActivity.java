package ca.gbc.comp3074.mind_manager_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmQuery;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Realm
        Realm.init(this);

        // Get a Realm instance for this thread
        Realm realm = Realm.getDefaultInstance();

        // Query looking for all users
        final RealmQuery<User> users = realm.where(User.class);

        final EditText username = findViewById(R.id.editUsername);
        final EditText password = findViewById(R.id.editPassword);
        final TextView lblError = findViewById(R.id.lblerrorlogin);

        //admin`s login/password (benjeff/123_Ben)

        //Button Login goes to welcome page to choose a mood(WelcomeActivity)
        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Execute the query, find if username input from user is existing in data base
                final User resultUsername = users.equalTo("userName", username.getText().toString()).findFirst();

                if(resultUsername != null && username.getText().toString().equals(resultUsername.getUserName()) &&
                        password.getText().toString().equals(resultUsername.getPassword())){
                    openWelcome();
                }
                else{
                  lblError.setText("User name or password invalid");
                }
            }
        });

        //Button Register goes to Registration page(RegisterActivity)
        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

        //Button About goes to About page(AboutActivity)
        Button btnAbout = findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });
    }

    //function to start WelcomeActivity
    private void openWelcome(){
        Intent start = new Intent(getApplicationContext(), WelcomeActivity.class);
        startActivity(start);
    }

    //function to start RegisterActivity
    private void openRegister(){
        Intent start = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(start);
    }

    //function to start AboutActivity
    private void openAbout(){
        Intent start = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(start);
    }
}