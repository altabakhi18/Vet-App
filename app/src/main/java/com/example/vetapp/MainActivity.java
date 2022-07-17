package com.example.vetapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText username, password;
    private AppCompatButton login;

    TextView insert;
    DBHelper DB = new DBHelper(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.txt_login_username);
        password = findViewById(R.id.txt_login_password);
        login = findViewById(R.id.btn_login);

        login.setOnClickListener(view -> {
                if(Objects.requireNonNull(username.getText()).length() > 0 && Objects.requireNonNull(password.getText()).length() > 0) {
                    String toastMessage = "Login Successful";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
                else{
                    String toastMessage = "Login Unsuccessful";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
        });

        insert = findViewById(R.id.txt_createAccountLink);

        insert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                boolean checkInsertData = DB.insertUserAccount("user@gmail.com", "password");
                if(checkInsertData){
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}