package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container, Home.class, null)
                    .commit();
        }
        findViewById(R.id.center_button).setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container, Center.class, null)
                    .commit();
        });
        findViewById(R.id.location_button).setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container, Location.class, null)
                    .commit();
        });
        findViewById(R.id.home_button).setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container, Home.class, null)
                    .commit();
        });
    }
}