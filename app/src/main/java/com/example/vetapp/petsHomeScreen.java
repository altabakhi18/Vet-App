package com.example.vetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class petsHomeScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets_home_screen);


//Appointment History Link//
       TextView aptHistory = (TextView) this.findViewById(R.id.link_petsApptHistory);
                aptHistory.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        startActivity(new Intent(petsHomeScreen.this, petsApptHistory.class));
                    }
                });

//CURRENT PRESCRIPTIONS Link//
        TextView petRX = (TextView) this.findViewById(R.id.link_petsCurrentRX);
        petRX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(petsHomeScreen.this, petsRX.class));
            }
        });

//VACCINATIONS Link//
        TextView petVax = (TextView) this.findViewById(R.id.link_petsVax);
        petVax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(petsHomeScreen.this, petsVax.class));
            }
        });


    }
}