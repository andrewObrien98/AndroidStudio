package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {//this means they are launching the app for te first time and we want to put a fragment there
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container, HomeFragment.class, null)
                    .commit();
        }
        findViewById(R.id.home_button).setOnClickListener(view -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container, HomeFragment.class, null)
                    .commit();
        });
        findViewById(R.id.dashboard_button).setOnClickListener(view -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container, DashBoardFragment.class, null)
                    .commit();
        });
        findViewById(R.id.settings_button).setOnClickListener(view -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container, SettingsFragment.class, null)
                    .commit();
        });

    }
}