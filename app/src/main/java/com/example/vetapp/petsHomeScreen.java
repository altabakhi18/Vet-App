package com.example.vetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class petsHomeScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets_home_screen);

        TextView button1 = findViewById(R.id.link_petsApptHistory);
        TextView button2 = findViewById(R.id.link_petsCurrentRX);
        TextView button3 = findViewById(R.id.link_petsVax);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.link_petsApptHistory:
                startActivity(new Intent(petsHomeScreen.this, petsApptHistory.class));
                break;
            case R.id.link_petsCurrentRX:
                startActivity(new Intent(petsHomeScreen.this, petsRX.class));
                break;
            case R.id.link_petsVax:
                startActivity(new Intent(petsHomeScreen.this, petsVax.class));
                break;
        }
    }
}