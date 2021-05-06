package com.example.workout;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.workout.UserDataBase.ExerciseDataBase;
import com.example.workout.UserDataBase.UserDataBase;
import com.example.workout.UserModels.Exercise;
import com.example.workout.UserModels.Users;

import java.util.ArrayList;

public class Practice extends AppCompatActivity {
    ArrayList<Exercise> exercise;
    ArrayList<Users> users;
    int size1 = 0;
    int size2 = 0;
    AppCompatTextView text1;
    AppCompatTextView text2;
    LinearLayout mainlayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserDataBase dataBase = Room.databaseBuilder(getApplicationContext(), UserDataBase.class, "user-database").build();
        ExerciseDataBase exerciseDataBase = Room.databaseBuilder(getApplicationContext(), ExerciseDataBase.class, "exercise-database").build();
        text1 = new AppCompatTextView(this);
        text2 = new AppCompatTextView(this);

        mainlayout = new LinearLayout(this);
        mainlayout.setOrientation(LinearLayout.VERTICAL);
        new Thread(() -> {
            Exercise exercise = new Exercise();
            exercise.password = "humbug";
            dataBase.getExerciseDao().insert(exercise);
        }).start();
        new Thread(() -> {
            Users user = new Users();
            user.name = "is a silly word";
            dataBase.getUserDao().insert(user);
        }).start();

        new Thread(() -> {
            exercise = (ArrayList<Exercise>) dataBase.getExerciseDao().getAllExercise();
            users = (ArrayList<Users>) dataBase.getUserDao().getAllUsers();
            size1 = exercise.size();
            size2 = users.size();
            renderExercises();
        }).start();


        text1.setText(-1 + " ");
        text2.setText(-1 + " ");

        mainlayout.addView(text1);
        mainlayout.addView(text2);
        setContentView(mainlayout);

    }

    public void renderExercises(){
        runOnUiThread(() -> {
            text1.setText(size1);
            text2.setText(size2);
            exercise.forEach(ex -> {
                TextView text = new TextView(this);
                text.setText(ex.password + "");
                mainlayout.addView(text);
            });
            TextView text = new TextView(this);
            text.setText("\n\n users \n\n");
            mainlayout.addView(text);

            users.forEach(user -> {
                TextView text1 = new TextView(this);
                text1.setText(user.name);
                mainlayout.addView(text1);
            });
        });
    }
}
