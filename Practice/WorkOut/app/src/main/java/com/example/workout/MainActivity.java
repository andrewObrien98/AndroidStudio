package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.workout.UserDataBase.UserDataBase;
import com.example.workout.UserModels.Users;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    UserDataBase userDataBase;
    ArrayList<Users> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        Intent intent1 = new Intent(MainActivity.this, Practice.class);
        startActivity(intent1);

        //////////////////////////////////////for creating a user ////////////////////////////////////////////////////////
        //userDataBase = Room.databaseBuilder(getApplicationContext(), UserDataBase.class, "user-database").build();
        Button newUser = findViewById(R.id.create_user_button);//when you want to create a new user this will happen
        newUser.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CreateUserActivity.class);
            startActivity(intent);
        });

        /////////////////////////////////////////////for the login ///////////////////////////////////////////////////////
        Button user = findViewById(R.id.go);//this is what happens when you login
        user.setOnClickListener(view -> {
            EditText password = findViewById(R.id.password_text);
            EditText name = findViewById(R.id.username_text);
            Intent intent = new Intent(MainActivity.this, WorkOutActivity.class);
            intent.putExtra("password",password.getText().toString());
            intent.putExtra("name", name.getText().toString());
            startActivity(intent);
        });

    }

}