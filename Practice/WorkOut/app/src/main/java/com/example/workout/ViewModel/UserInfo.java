package com.example.workout.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.widget.AppCompatButton;

import com.example.workout.UserDataBase.UserDataBase;
import com.example.workout.UserModels.Exercise;

import java.util.ArrayList;

public class UserInfo {
    Intent intent;
    String password;
    String name;
    ArrayList<Exercise> exercises;
    UserDataBase database;
    ArrayList<String> dates;
    ArrayList<Exercise> goals;
    public UserInfo(Intent i, UserDataBase data){
        intent = i;
        password = intent.getStringExtra("password");
        name = intent.getStringExtra("name");
        database = data;
    }

    public void getExercises(){
        exercises = new ArrayList<>();
        new Thread(() -> {
           exercises = (ArrayList<Exercise>) database.getExerciseDao().getAllExercise();
           findDates();
           findGoals();
        });
    }

    public void findGoals(){
        goals = new ArrayList<>();
        new Thread(() -> {
            for (Exercise exercise : exercises) {
                if(exercise.date.equals("Goals")){
                    goals.add(exercise);
                }
            }
        });
    }

    public void findDates(){
        dates = new ArrayList<>();
        new Thread(() -> {
            exercises.forEach(exercise -> {
                if(!dates.contains(exercise.date)){
                    dates.add(exercise.date);
                }
            });
        });
    }

    public ArrayList<Exercise> getExercise(){
        return exercises;
    }

    public ArrayList<String> getDates(){
        return dates;
    }

    public String getPassword(){
        return password;
    }

    public UserDataBase getDatabase(){
        return database;
    }

    public ArrayList<Exercise> getGoals(){
        return goals;
    }

    public String getName(){
        return name;
    }

}

