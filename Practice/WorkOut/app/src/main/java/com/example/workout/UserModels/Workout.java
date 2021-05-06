package com.example.workout.UserModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Workout {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "workout")
    public String workout;

    @ColumnInfo(name = "quantity")
    public String quantity;

    @ColumnInfo(name = "unit")
    public String unit;

    @ColumnInfo(name = "amount")
    public String amount;

    @ColumnInfo(name = "amountUnit")
    public String amountUnit;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "date")
    public String date;
}
