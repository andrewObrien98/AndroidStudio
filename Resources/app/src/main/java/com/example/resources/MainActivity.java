package com.example.resources;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        AppCompatButton button = new AppCompatButton(this);
        button.setBackgroundColor(getResources().getColor(R.color.ButtonColor));
        button.setTextColor(getColor(R.color.ButtonText));
        button.setText("I am the button");
        mainLayout.addView(button);
        AppCompatTextView firstName = new AppCompatTextView(this);
        firstName.setText(getResources().getString(R.string.first_name));
        mainLayout.addView(firstName);
        AppCompatTextView lastName = new AppCompatTextView(this);
        lastName.setText(getResources().getString(R.string.last_name));
        mainLayout.addView(lastName);
        setContentView(mainLayout);
    }
}