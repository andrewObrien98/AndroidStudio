package com.example.myapplication.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.models.Todo;

import java.util.List;

@Dao//data access object
public interface TodoDao {
    @Query("SELECT * FROM todo")//the todo matches the class, you just put this sql in as lower case..... the star means everything
    List<Todo> getAllTodos();

    @Insert
    void insert(Todo todo);

    @Update
    void update(Todo todo);
}
