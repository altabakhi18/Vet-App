package com.example.vetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Happy Paws");


//BUTTON TO GO TO PETS HOME SCREEN//
        Button b1 = (Button)findViewById(R.id.btn_pets);
        Button b2 = (Button)findViewById(R.id.btn_appts);
        Button b3 = (Button)findViewById(R.id.btn_emergency);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, petsHomeScreen.class));

//BUTTON TO GO TO APPOINTMENT REQUEST SCREEN//
        b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, appt_request.class));

//BUTTON TO GO TO EMERGENCY SCREEN//
         b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, emergency.class));

                       }
                    });
                 }
             });
         }
    });
}}