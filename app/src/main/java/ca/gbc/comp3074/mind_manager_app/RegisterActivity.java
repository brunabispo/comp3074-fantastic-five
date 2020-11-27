package ca.gbc.comp3074.mind_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        TextView editFirstName = findViewById(R.id.editName);
        String getFirstName = editFirstName.getText().toString();

        TextView editUsername = findViewById(R.id.editUsername);
        final String getUsername = editUsername.getText().toString();

        TextView editPassword = findViewById(R.id.editPassword);
        final String getPassword = editPassword.getText().toString();

        TextView editConfirmPassword = findViewById(R.id.editConfirmPass);
        final String getConfirmPassword = editConfirmPassword.getText().toString();

        //Insert
        realm.beginTransaction();
        final User user = new User (getFirstName,getUsername,getPassword);

        final RealmQuery<User> users =  realm.where(User.class);

        TextView lblConfirmPass = findViewById(R.id.lblConfirmPass);
        lblConfirmPass.setText("Confirm\nPassword");

        final TextView lblError = findViewById(R.id.lblError);

        final User userTest = new User(getFirstName, getUsername, getPassword);

        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User checkUsername = users.equalTo("userName",getUsername).findFirst();

                if(checkUsername != null && getPassword.equals(getConfirmPassword)){
                    //Write in data base
                    realm.copyToRealm(user);
                    realm.commitTransaction();
                    Toast.makeText(RegisterActivity.this, userTest.toString(),
                            Toast.LENGTH_LONG).show();
                    realm.close();
                    backToLogin();
                }
                if(checkUsername == null){
                    lblError.setText("This user name is already taken");
                }
                if (!getPassword.equals(getConfirmPassword)){
                    lblError.setText("The passwords does not match");
                }
            }
        });


        Button btnCancel = findViewById(R.id.btnCancel);

        //Button Cancel goes back to the login page(MainActivity)
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.close();
                backToLogin();
            }
        });


    }

    //function to start MainActivity
    private void backToLogin(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }

    private void backToRegistration(){
        Intent start = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(start);
    }
}


