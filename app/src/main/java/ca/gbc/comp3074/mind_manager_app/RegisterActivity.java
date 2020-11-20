package ca.gbc.comp3074.mind_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView lblConfirmPass = findViewById(R.id.lblConfirmPass);
        lblConfirmPass.setText("Confirm\nPassword");

        Button btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToLogin();
            }
        });


        Button btnCancel = findViewById(R.id.btnCancel);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToLogin();
            }
        });

    }


    private void backToLogin(){
        Intent start = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start);
    }
}


