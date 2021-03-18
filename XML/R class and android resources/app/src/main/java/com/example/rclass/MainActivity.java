package com.example.rclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         AppCompatEditText emailEditText = findViewById(R.id.email_edit_text);
         AppCompatEditText passwordEditText = findViewById(R.id.password_edit_text);
        AppCompatButton loginButton = findViewById(R.id.password_button);

        loginButton.setOnClickListener(view -> {
            System.out.println("Email: " + emailEditText.getText().toString());
            System.out.println("Password: " + passwordEditText.getText().toString());
        });

    }
}