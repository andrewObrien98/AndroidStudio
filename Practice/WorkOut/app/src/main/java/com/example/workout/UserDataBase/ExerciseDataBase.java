package com.example.workout.UserDataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.workout.UserModels.Exercise;

@Database(entities = {Exercise.class}, version = 1)
public abstract class ExerciseDataBase extends RoomDatabase {
    public abstract ExerciseDao getExerciseDao();
}
