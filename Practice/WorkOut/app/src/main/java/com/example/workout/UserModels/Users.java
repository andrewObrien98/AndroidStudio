package com.example.workout.UserModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.workout.UserDataBase.UserDataBase;

import java.util.ArrayList;

@Entity(indices = {@Index(value = {"password"},unique = true)})

public class Users {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "name")
    public String name;



}
