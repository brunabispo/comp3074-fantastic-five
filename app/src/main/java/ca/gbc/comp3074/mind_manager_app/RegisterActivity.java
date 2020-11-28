package ca.gbc.comp3074.mind_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import io.realm.Realm;
import io.realm.RealmQuery;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Get a Realm instance for this thread
        final Realm realm = Realm.getDefaultInstance();

        final TextView editFirstName = findViewById(R.id.editName);
        final TextView editUsername = findViewById(R.id.editUsername);
        final TextView editPassword = findViewById(R.id.editPassword);
        final TextView editConfirmPassword = findViewById(R.id.editConfirmPass);
        final TextView lblError = findViewById(R.id.lblError);

        //Query looking for all users
        RealmQuery<User> users =  realm.where(User.class);

        //Execute the query, find if username input from user is existing in data base
        final User resultUsername = users.equalTo("userName", editUsername.getText().toString()+"").findFirst();

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editPassword.getText().toString().equals(editConfirmPassword.getText().toString())){
                    lblError.setText("Password and Confirm Password not match");
                }
                else if(resultUsername != null){
                    backToRegistration();
                    lblError.setText("This user name is already exist"+ resultUsername.getUserName());
                }
                else if(resultUsername == null && (editPassword.getText().toString().equals(editConfirmPassword.getText().toString()))){
                    //Insert
                    realm.beginTransaction();
                    final User user = new User (""+editFirstName.getText().toString()+"",
                            ""+editUsername.getText().toString()+"", ""+editPassword.getText().toString()+"");

                    //Write in data base
                    realm.copyToRealm(user);
                    realm.commitTransaction();
                    backToRegistration();
                    lblError.setText("This user name is new one");
                }

            }
        });

        //Button Cancel goes back to the login page(MainActivity)
        Button btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToLogin();
            }
        });
    }

    //function to start MainActivity
    private void backToLogin(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }

    //function to start MainActivity
    private void backToRegistration(){
        Intent start = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(start);
    }
}


