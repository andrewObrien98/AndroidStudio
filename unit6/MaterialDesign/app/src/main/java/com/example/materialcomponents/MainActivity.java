package com.example.materialcomponents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        AppCompatButton regularButton = new AppCompatButton(this);
        regularButton.setText("I am a regular button");

        MaterialButton materialButton = new MaterialButton(this, null, R.attr.materialButtonOutlinedStyle);//borderlessButtonStyle
        materialButton.setText("I am a materialButton");

        mainLayout.addView(regularButton);
        mainLayout.addView(materialButton);
        setContentView(mainLayout);
    }
}