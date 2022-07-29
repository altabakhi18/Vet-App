package com.example.vetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.btn_pets);
        Button button2 = (Button) findViewById(R.id.btn_appts);
        Button button3 = (Button) findViewById(R.id.btn_emergency);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_pets:
                startActivity(new Intent(MainActivity.this, petsHomeScreen.class));
                break;
            case R.id.btn_appts:
                startActivity(new Intent(MainActivity.this, appts.class));
                break;
            case R.id.btn_emergency:
                startActivity(new Intent(MainActivity.this, emergency.class));
                break;
        }
    }
}