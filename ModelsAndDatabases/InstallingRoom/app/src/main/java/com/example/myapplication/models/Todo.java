package com.example.myapplication.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//databases consist of rows and columns
//id will be a column , contents will be a column, isComplete will be a column

@Entity
public class Todo {
    @PrimaryKey(autoGenerate = true)//this goes to the field that uniquely identifies everything
    public int id;

    @ColumnInfo(name = "contents")
    public String contents;

    @ColumnInfo(name = "is_complete")
    public boolean isComplete;
}
