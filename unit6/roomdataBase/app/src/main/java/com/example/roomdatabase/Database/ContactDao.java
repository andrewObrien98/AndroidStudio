package com.example.roomdatabase.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabase.models.Contacts;

import java.util.List;

//CRUD operation Create Read Update Delete
@Dao
public interface ContactDao {

    @Query("SELECT * FROM contacts")
    public List<Contacts> getAll();

    @Query("SELECT * FROM contacts WHERE id = :id LIMIT 1")
    public Contacts findById(long id);

    @Insert
    public long insert(Contacts contact);

    @Update
    public void update(Contacts contact);

    @Delete
    public void delete(Contacts contact);
}
