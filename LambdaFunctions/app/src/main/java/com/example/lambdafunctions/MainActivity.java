package com.example.lambdafunctions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatButton button = new AppCompatButton(this);
        button.setText("Click Me");
        button.setOnClickListener(view ->{
            Log.d("I got pressed", "yay");
        });

        ArrayList<Integer> ages = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(40);
            add(6);
        }
        };
        ages.forEach(age ->{
           Log.d("age doubles", age*2 + "");
        });
        ages.removeIf(age ->{
           return age > 30;
        });

        setContentView(button);
    }
}