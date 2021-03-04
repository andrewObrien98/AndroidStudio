package com.example.complexlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //nested layouts
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        //Username
        LinearLayout usernameLayout = new LinearLayout(this);
        AppCompatTextView usernameView = new AppCompatTextView(this);
        AppCompatEditText userNameField = new AppCompatEditText(this);
        usernameView.setText("Username: ");
        usernameLayout.addView(usernameView);
        usernameLayout.addView(userNameField);

        //Password
        LinearLayout passwordLayout = new LinearLayout(this);
        AppCompatTextView passwordView = new AppCompatTextView(this);
        AppCompatEditText passwordField = new AppCompatEditText(this);
        passwordView.setText("Password: ");
        passwordLayout.addView(passwordView);
        passwordLayout.addView(passwordField);

        //mainLayout
        mainLayout.addView(usernameLayout);
        mainLayout.addView(passwordLayout);
        setContentView(mainLayout);
    }
} 