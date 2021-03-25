package ca.gbc.comp3074.mind_manager_app.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;

import ca.gbc.comp3074.mind_manager_app.GoogleMySQLConnectionHelper;
import ca.gbc.comp3074.mind_manager_app.Models.User;
import ca.gbc.comp3074.mind_manager_app.R;

public class AdminAddNewQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_question);

        //Database instance
        final GoogleMySQLConnectionHelper db = new GoogleMySQLConnectionHelper();
        final Connection connect = db.connectionclass();

        final TextView editFirstName = findViewById(R.id.editName);
        final TextView editUserName = findViewById(R.id.editUsername);
        final TextView editPassword = findViewById(R.id.editPassword);
        final TextView editConfirmPassword = findViewById(R.id.editConfirmPass);
        final TextView lblError = findViewById(R.id.lblError);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Execute the query, find if username input from user is existing in data base
                User userExist = db.getUser(connect, editUserName.getText().toString());

                if(userExist != null){
                    lblError.setText("This user name is already exist");
                }
                else if (!editPassword.getText().toString().equals(editConfirmPassword.getText().toString())){
                    lblError.setText("Password and Confirm Password not match");
                } else{
                    //Insert new user
                    User user = new User("user", editUserName.getText().toString()+"",
                            editFirstName.getText().toString()+"", editPassword.getText().toString()+"");
                    db.addUser(connect, user);
                    backToAdminQuestionnaire();
                }
            }
        });

        //Button Cancel goes back to AdminQuestionnaireActivity
        Button btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToAdminQuestionnaire();
            }
        });
    }

    //function to start AdminQuestionnaireActivity
    private void backToAdminQuestionnaire(){
        Intent start = new Intent(getApplicationContext(), AdminQuestionnaireActivity.class);
        startActivity(start);
    }
}
