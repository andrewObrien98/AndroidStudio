package com.example.getyoked.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ExerciseEntry {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "type")
    public String type;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "workout")
    public String workout;

    @ColumnInfo(name = "quantity")
    public String quantity;

    @ColumnInfo(name = "unit")
    public String unit;

    @ColumnInfo(name = "amount")
    public String amount;

    @ColumnInfo(name = "amount_unit")
    public String amountUnit;
}
