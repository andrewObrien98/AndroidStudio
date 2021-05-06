package com.example.workout.UserDataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.Update;

import com.example.workout.UserModels.Users;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<Users> getAllUsers();

    @Insert
    void insert(Users user);

    @Update
    void update(Users user);

//    @Query("SELECT * FROM users WHERE password = :password LIMIT 1")
//    Users findUserById(String password);
}
