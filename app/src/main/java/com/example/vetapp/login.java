package com.example.vetapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.widget.Toast;


public class login extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    EditText email, password;
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

        email = (EditText) findViewById(R.id.txt_login_username);
        password = (EditText) findViewById(R.id.txt_login_password);

        mAuth = FirebaseAuth.getInstance();

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_createAccountLink:
                startActivity(new Intent(login.this, createaccount.class));
                break;
            case R.id.btn_login:
                userLogin();
                break;
        }
    }

    private void userLogin() {
        String emailString = email.getText().toString();
        String passString = password.getText().toString();

        if(emailString.isEmpty()){
            email.setError("Email is required!");
            email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(emailString).matches()){
            email.setError("Please enter a valid email.");
            email.requestFocus();
        }

        if(passString.isEmpty()){
            password.setError("Password is required!");
            password.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(emailString, passString)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(login.this, MainActivity.class));
                        }else{
                            Toast.makeText(login.this, "Failed to login! Please check your credentials.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}