package com.example.vetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class login extends AppCompatActivity implements View.OnClickListener{

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
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_createAccountLink:
                startActivity(new Intent(login.this, createaccount.class));
                break;
            case R.id.btn_login:
                startActivity(new Intent(login.this, MainActivity.class));
                break;
        }
    }
}
