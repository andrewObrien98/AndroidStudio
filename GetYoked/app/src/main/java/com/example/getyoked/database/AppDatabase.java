package com.example.getyoked.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.getyoked.models.ExerciseEntry;

@Database(entities = {ExerciseEntry.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WorkoutEntriesDao getWorkoutEntriesDao();
}
