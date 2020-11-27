package ca.gbc.comp3074.mind_manager_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Testing login functionality
    String user = "benjeff";
    String pass = "123_Ben";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username = findViewById(R.id.editUsername);

        final EditText password = findViewById(R.id.editPassword);

        Button btnLogin = findViewById(R.id.btnLogin);

        //Button Login goes to welcome page to choose a mood(WelcomeActivity)
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals(user) &&
                        password.getText().toString().equals(pass)){
                    openWelcome();
                }
                else{
                    backToLogin();
                    Toast.makeText(MainActivity.this, "Incorrect Username or Password",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        Button btnRegister = findViewById(R.id.btnRegister);
        //Button Register goes to Registration page(RegisterActivity)
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

        Button btnAbout = findViewById(R.id.btnAbout);
        //Button About goes to About page(AboutActivity)
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

    private void backToLogin(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }
}