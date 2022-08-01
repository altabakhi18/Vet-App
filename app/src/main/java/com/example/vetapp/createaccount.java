package com.example.vetapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class createaccount extends AppCompatActivity {

    EditText accFirstName, accLastName, accPhone, accEmail, accUsername, accPassword;
    //Button insert, update, delete;
    Button insert;
    DatabaseReference reff;
    UserAccount userAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        accFirstName = findViewById(R.id.txt_create_firstname);
        accLastName = findViewById(R.id.txt_create_lastname);
        accEmail = findViewById(R.id.txt_create_email);
        accPhone = findViewById(R.id.txt_create_phone);
        accUsername = findViewById(R.id.txt_create_username);
        accPassword = findViewById(R.id.txt_create_password);
        insert = (Button) findViewById(R.id.btn_createaccount);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstNameTXT = accFirstName.getText().toString();
                String lastNameTXT = accLastName.getText().toString();
                int phoneInt = Integer.parseInt(accPhone.getText().toString());
                String emailTXT = accEmail.getText().toString();
                String usernameTXT = accUsername.getText().toString();
                String passwordTXT = accPassword.getText().toString();
                userAccount = new UserAccount();
                reff = FirebaseDatabase.getInstance().getReference().child("UserAccount");

                insert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        userAccount.setFirstName(firstNameTXT);
                        userAccount.setLastName(lastNameTXT);
                        userAccount.setPhone(phoneInt);
                        userAccount.setEmail(emailTXT);
                        userAccount.setUsername(usernameTXT);
                        userAccount.setPassword(passwordTXT);

                        reff.push().setValue(userAccount);
                        Toast.makeText(createaccount.this, "data inserted successfully", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}