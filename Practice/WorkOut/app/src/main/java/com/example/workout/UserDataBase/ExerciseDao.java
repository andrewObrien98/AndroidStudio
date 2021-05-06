package com.example.workout.UserDataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.Update;

import com.example.workout.UserModels.Exercise;
import com.example.workout.UserModels.Users;

import java.util.List;

@Dao
public interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    List<Exercise> getAllExercise();

    @Insert
    void insert(Exercise exercise);

    @Update
    void update(Exercise exercise);

    @Query("SELECT * FROM exercise WHERE password = :password")//probably need to fix this//hope this returns a list
    Exercise findUserById(String password);

    @Query("SELECT * FROM exercise WHERE password = :password")
    List<Exercise> getAllExercises(String password);
}