package com.example.roomdatabase.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomdatabase.models.Contacts;

@Database(entities = {Contacts.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactDao getContactsDao();
}
