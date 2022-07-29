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

class Main extends AppCompatActivity {
private Button button;

    EditText username;
    EditText password;
    //Button insert, update, delete, view;
    TextView create;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        username = (EditText) findViewById(R.id.txt_login_username);
        password = (EditText) findViewById(R.id.txt_login_password);
        String user = username.getText().toString();
        String pass = password.getText().toString();



        button = findViewById(R.id.btn_login);
            if(user == "default" && pass == "password") {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Main.this, homescreen.class));
                    }
                });
            }
            else{
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        TextView accountCreate = (TextView) findViewById(R.id.txt_createAccountLink);
        accountCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main.this, createAccount.class));
            }
        });
    }
}
