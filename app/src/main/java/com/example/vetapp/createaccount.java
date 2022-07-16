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

public class createaccount extends AppCompatActivity {

    EditText accEmail, accPassword;
    //Button insert, update, delete;
    Button insert;
    DatabaseReference reff;
    UserAccount userAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        accEmail = findViewById(R.id.txt_create_email);
        accPassword = findViewById(R.id.txt_create_password);
        insert = (Button) findViewById(R.id.btn_createaccount);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailTXT = accEmail.getText().toString();
                String passwordTXT = accPassword.getText().toString();
                userAccount = new UserAccount();
                reff = FirebaseDatabase.getInstance().getReference().child("Member");
                insert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userAccount.setEmail(emailTXT);
                        userAccount.setPassword(passwordTXT);

                        reff.push().setValue(userAccount);
                        Toast.makeText(createaccount.this, "data inserted successfully", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}