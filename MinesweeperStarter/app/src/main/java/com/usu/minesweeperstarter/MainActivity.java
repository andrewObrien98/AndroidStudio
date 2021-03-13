package com.usu.minesweeperstarter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        Header gameTitle = new Header(this);
        mainLayout.addView(gameTitle);

        //easy
        AppCompatButton easyButton = new AppCompatButton(this);
        easyButton.setText("Beginner");
        easyButton.setTextSize(24);
        easyButton.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            intent.putExtra("difficulty", "beginner");
            startActivity(intent);
        });
        mainLayout.addView(easyButton);

        //intermediate
        AppCompatButton mediumButton = new AppCompatButton(this);
        mediumButton.setText("Intermediate");
        mediumButton.setTextSize(24);
        mediumButton.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            intent.putExtra("difficulty", "intermediate");
            startActivity(intent);
        });
        mainLayout.addView(mediumButton);

        //difficult
        AppCompatButton hardButton = new AppCompatButton(this);
        hardButton.setText("Expert");
        hardButton.setTextSize(24);
        hardButton.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            intent.putExtra("difficulty", "expert");
            startActivity(intent);
        });
        mainLayout.addView(hardButton);


        setContentView(mainLayout);
        // TODO: create the views for the main page and transition
        //  to the main page once the difficulty is selected
    }
}