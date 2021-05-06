package com.example.workout.UserDataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.workout.UserModels.Exercise;
import com.example.workout.UserModels.Users;

@Database(entities = {Users.class}, version = 1)

public abstract class UserDataBase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
