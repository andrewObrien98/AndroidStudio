package com.example.appswithmultipleactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        Header loginHeader = new Header(this, "Login Info");
        LabelledInput userName = new LabelledInput(this,"UserName: ");
        LabelledInput password = new LabelledInput(this,"Password: ");

        Header personalHeader = new Header(this, "Personal Info: ");
        LabelledInput address = new LabelledInput(this,"address: ");
        LabelledInput number = new LabelledInput(this,"number: ");
        LabelledInput email = new LabelledInput(this,"email: ");

        AppCompatButton submitButton = new AppCompatButton(this);
        submitButton.setText("Submit");
        submitButton.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, HomeActivity.class); // this says that we intent to transition from main context to this new activity
            String firstName = email.getText().toString();
            intent.putExtra("firstName", firstName);
            startActivity(intent);
        });

        layout.addView(loginHeader);
        layout.addView(userName);
        layout.addView(password);
        layout.addView(personalHeader);
        layout.addView(address);
        layout.addView(number);
        layout.addView(email);
        layout.addView(submitButton);

        setContentView(layout);
    }
}