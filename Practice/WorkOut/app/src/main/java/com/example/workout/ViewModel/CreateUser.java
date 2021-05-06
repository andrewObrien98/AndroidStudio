package com.example.workout.ViewModel;

import android.view.textclassifier.TextClassification;

import androidx.room.Room;

import com.example.workout.UserDataBase.UserDataBase;
import com.example.workout.UserModels.Exercise;
import com.example.workout.UserModels.Users;

import java.util.ArrayList;

public class CreateUser {
    UserDataBase dataBase;
    String name;
    String password;
    public CreateUser(String name, String passWord, UserDataBase d){
        dataBase = d;
        this.name = name;
        this.password = passWord;
    }

    public void addExercise( String workOut, String q, String u, String a, String au, String d){
        Exercise exercise = new Exercise();
        exercise.workout = workOut;
        exercise.quantity = q;
        exercise.unit = u;
        exercise.amount = a;
        exercise.amountUnit = au;
        exercise.password = password;
        exercise.date = d;
        new Thread (() -> {
            dataBase.getExerciseDao().insert(exercise);
        });
    }

    public void addToDatabase(){
        Users user = new Users();
        user.name = name;
        user.password = password;
        new Thread(() -> {
            dataBase.getUserDao().insert(user);
        });
    }

}
