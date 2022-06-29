package com.example.vetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    //Button insert, update, delete, view;
    TextView insert;
    DatabaseReference reff;
    UserAccount userAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email = (EditText) findViewById(R.id.txt_login_username);
        password = (EditText) findViewById(R.id.txt_login_password);
        insert = findViewById(R.id.txt_createAccountLink);

        insert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String emailTXT = email.getText().toString();
                String passwordTXT = password.getText().toString();
                userAccount = new UserAccount();
                reff = FirebaseDatabase.getInstance().getReference().child("Member");
                insert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userAccount.setEmail(emailTXT);
                        userAccount.setPassword(passwordTXT);

                        reff.push().setValue(userAccount);
                        Toast.makeText(MainActivity.this, "data inserted successfully", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}