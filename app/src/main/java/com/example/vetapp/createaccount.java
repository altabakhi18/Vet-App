package com.example.vetapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class createaccount extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText accFirstName, accLastName, accPhone, accEmail, accUsername, accPassword, accVerifyPass;
    //Button insert, update, delete;
    Button insert;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        mAuth = FirebaseAuth.getInstance();

        accFirstName = findViewById(R.id.txt_create_firstname);
        accLastName = findViewById(R.id.txt_create_lastname);
        accEmail = findViewById(R.id.txt_create_email);
        accPhone = findViewById(R.id.txt_create_phone);
        accUsername = findViewById(R.id.txt_create_username);
        accPassword = findViewById(R.id.txt_create_password);
        accVerifyPass = findViewById(R.id.txt_create_passwordverify);
        insert = (Button) findViewById(R.id.btn_createaccount);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                insert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        register();
                    }
                });
            }
        });
    }

    public void register(){
        String firstNameTXT = accFirstName.getText().toString().trim();
        String lastNameTXT = accLastName.getText().toString().trim();
        String phoneTXT = accPhone.getText().toString().trim();
        String emailTXT = accEmail.getText().toString().trim();
        String usernameTXT = accUsername.getText().toString().trim();
        String passwordTXT = accPassword.getText().toString().trim();
        String verifyPassTXT = accPassword.getText().toString().trim();

        if(firstNameTXT.isEmpty()){
            accFirstName.setError("First name is required!");
            accFirstName.requestFocus();
            return;
        }

        if(lastNameTXT.isEmpty()){
            accLastName.setError("Last name is required!");
            accLastName.requestFocus();
            return;
        }

        if(emailTXT.isEmpty()){
            accEmail.setError("Email is required!");
            accEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(emailTXT).matches()){
            accEmail.setError("Please provide a valid email.");
            accEmail.requestFocus();
            return;
        }

        if(phoneTXT.isEmpty()){
            accPhone.setError("Phone number is required!");
            accPhone.requestFocus();
            return;
        }

        if(!(passwordTXT.equals(verifyPassTXT))){
            accVerifyPass.setError("Passwords must match!");
            accVerifyPass.requestFocus();
            return;
        }



        mAuth.createUserWithEmailAndPassword(emailTXT, passwordTXT)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            UserAccount user = new UserAccount(firstNameTXT, lastNameTXT, phoneTXT, emailTXT, usernameTXT, passwordTXT);
                            FirebaseDatabase.getInstance().getReference("UserAccounts")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(createaccount.this, "Account Created Successfully!", Toast.LENGTH_LONG).show();
                                                startActivity(new Intent(createaccount.this, login.class));
                                            }
                                            else {
                                                Toast.makeText(createaccount.this, "Failed to register.", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                        }else{
                            Toast.makeText(createaccount.this, "Failed to register.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_create_backtologin:
                startActivity(new Intent(createaccount.this, login.class));
                break;
        }
    }
}