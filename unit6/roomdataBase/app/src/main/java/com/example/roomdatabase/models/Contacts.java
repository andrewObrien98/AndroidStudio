package com.example.roomdatabase.models;


/*
Contact
=============================================
id    |    name   | email   | phoneNumber   |
=============================================
1     |    andrew  | ap@gmai   | 11111111   |
---------------------------------------------
2     |    josh    | g@gmai   | 123123123   |


 */

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contacts {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name="name")
    public String name;

    @ColumnInfo(name="email")
    public String email;

    @ColumnInfo(name="phone_number")
    public long phoneNumber;
}
