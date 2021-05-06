package com.example.mvvmcounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mvvmcounter.viewmodels.CounterViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Model - View - ViewModel
        //solves how to maintain proper abstraction between layers
        //view -> viewmodel -> model
        CounterViewModel counterVM = new CounterViewModel();

        counterVM.getCount().observe(this, (count) -> {
            TextView text = findViewById(R.id.count);
            text.setText(count + "");
        });

        counterVM.getCount2().observe(this, (count) -> {
            TextView text = findViewById(R.id.counter2);
            text.setText(count + "");
        });

        counterVM.getWorkouts().observe(this, (workout) -> {
            TextView legs = findViewById(R.id.legs);
            legs.setText(workout + "");
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.decrement).setOnClickListener(view -> {
            counterVM.decrement();
        });
        findViewById(R.id.increment).setOnClickListener(view -> {
            counterVM.increment();
        });
    }
}