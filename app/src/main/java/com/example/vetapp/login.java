package com.example.vetapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public abstract class login extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    //Button insert, update, delete, view;
    TextView create;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        TextView accountCreate = (TextView) findViewById(R.id.txt_createAccountLink);
        accountCreate.setOnClickListener(this);

        Button login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(this);

        username = (EditText) findViewById(R.id.txt_login_username);
        password = (EditText) findViewById(R.id.txt_login_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String un = username.getText().toString();
                String pw = password.getText().toString();

                if (un.equals("default") && pw.equals("password")) {
                    Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this, createAccount.class));
                } else {
                    Toast.makeText(login.this, "Try again", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
}