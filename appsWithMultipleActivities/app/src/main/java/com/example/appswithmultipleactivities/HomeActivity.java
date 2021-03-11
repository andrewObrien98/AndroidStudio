package com.example.appswithmultipleactivities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        AppCompatTextView welcomeText = new AppCompatTextView(this);
        Intent intent = getIntent();
        String firstName = intent.getStringExtra("firstName");
        welcomeText.setText("Welcome to the homepage, " + firstName + "!");
        setContentView(welcomeText);
    }
}
