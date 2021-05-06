package com.example.getyoked.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.getyoked.models.ExerciseEntry;

import java.util.List;

@Dao
public interface WorkoutEntriesDao {

    @Insert
    public long insert(ExerciseEntry entry);

    @Query("Select * FROM exerciseentry")
    public List<ExerciseEntry> getAll();

    @Query("Select * FROM exerciseentry where type = :type")//this will return a list with the type that you want
    public List<ExerciseEntry> getAllGoals(String type);

    @Query("Select * FROM exerciseentry where date = :date")//this will return a list with the the exercises from a date
    public List<ExerciseEntry> getAllFomADate(String date);

    @Query("SELECT * FROM exerciseentry where id = :id LIMIT 1")
    public ExerciseEntry findById(long id);

    @Update
    public void update(ExerciseEntry entry);

    @Delete
    public void delete(ExerciseEntry entry);
}
