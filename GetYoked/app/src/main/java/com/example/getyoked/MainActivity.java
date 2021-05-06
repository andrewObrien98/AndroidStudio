package com.example.getyoked;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.getyoked.Fragment.Goals;
import com.example.getyoked.Fragment.Workouts;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.main_fragment_container, new Workouts(), null)
                    .commit();
        }

        MaterialButton workOutButton = findViewById(R.id.workouts_button);
        workOutButton.setOnClickListener(view -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.main_fragment_container, new Workouts(), null)
                    .addToBackStack(null)
                    .commit();
        });

        MaterialButton goalsButton = findViewById(R.id.goals_button);
        goalsButton.setOnClickListener(view -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.main_fragment_container, new Goals(), null)
                    .addToBackStack(null)
                    .commit();
        });
    }
}