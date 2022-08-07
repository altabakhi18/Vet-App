package com.example.vetapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class appt_request extends AppCompatActivity {
        AppCompatButton submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appt_request);
        submit = findViewById(R.id.aptReq_btn_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(appt_request.this, "Thank you for your request!", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(appt_request.this, MainActivity.class));
            }
        });
    }
}