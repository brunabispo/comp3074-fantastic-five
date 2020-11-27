package ca.gbc.comp3074.mind_manager_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        final Realm realm = Realm.getDefaultInstance();

        //Insert
        realm.beginTransaction();
        User user = new User ("Ben","benjeff","123_Ben");

        //Write in data base
        realm.copyToRealm(user);
        realm.commitTransaction();

        //Query looking for all users
        RealmQuery<User> users =  realm.where(User.class);

        final EditText username = findViewById(R.id.editUsername);
        final String getUsername = username.getText().toString();
        final EditText password = findViewById(R.id.editPassword);
        final TextView lblError = findViewById(R.id.lblerrorlogin);

        //Execute the query
        final User resultUsername = users.equalTo("userName", getUsername).findFirst();

        Button btnLogin = findViewById(R.id.btnLogin);
        //Button Login goes to welcome page to choose a mood(WelcomeActivity)
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals(resultUsername.getUserName()) &&
                        password.getText().toString().equals(resultUsername.getPassword())){
                    realm.close();
                    openWelcome();
                }
                else{
                  lblError.setText("User name or password invalid");
                }
            }
        });

        Button btnRegister = findViewById(R.id.btnRegister);
        //Button Register goes to Registration page(RegisterActivity)
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.close();
                openRegister();
            }
        });

        Button btnAbout = findViewById(R.id.btnAbout);
        //Button About goes to About page(AboutActivity)
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.close();
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

    private void backToLogin(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }
}