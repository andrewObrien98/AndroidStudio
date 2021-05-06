package com.example.workout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.room.Room;

import com.example.workout.UserDataBase.UserDataBase;
import com.example.workout.UserModels.Users;
import com.example.workout.ViewModel.CreateUser;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CreateUserActivity extends AppCompatActivity {
    UserDataBase userDataBase;
    int amount1 = 0;
    CreateUser user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_user);
        userDataBase = Room.databaseBuilder(getApplicationContext(), UserDataBase.class, "user-database").build();

        //ScrollView goalsView = findViewById(R.id.scroll_view_workouts);
        LinearLayout mainLayout = findViewById(R.id.linearLayout);
        ScrollView goalsView = new ScrollView(this);
        LinearLayout goalsLayout = new LinearLayout(this);
        goalsLayout.setOrientation(LinearLayout.VERTICAL);

        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(view -> {
            TextView workout = findViewById(R.id.workout_text);
            TextView quantity = findViewById(R.id.quantity_text);
            TextView unit = findViewById(R.id.unit_text);
            TextView amount = findViewById(R.id.amount_text);
            TextView unitAmount = findViewById(R.id.unit_amount_text);
            if(amount1 == 0){
                amount1++;
                TextView name = findViewById(R.id.name);
                TextView password = findViewById(R.id.new_password);
                user = new CreateUser(name.getText().toString(), password.getText().toString(), userDataBase);
            }
            user.addExercise(workout.getText().toString(), quantity.getText().toString(), unit.getText().toString(), amount.getText().toString(), unitAmount.getText().toString(), "Goal");

            AppCompatTextView goal = new AppCompatTextView(this);
            goal.setText(workout.getText().toString() + ":  "+  quantity.getText().toString()+"  "+ unit.getText().toString()+"  "+ amount.getText().toString()+"  "+ unitAmount.getText().toString());
            goalsLayout.addView(goal);
        });

        Button create = findViewById(R.id.create_new_user_go_button);
        create.setOnClickListener(view -> {
            if(amount1 > 0){
                user.addToDatabase();
                Intent intent = new Intent(CreateUserActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        goalsView.addView(goalsLayout);
        mainLayout.addView(goalsView);

    }


}