package com.example.mynotes.DataBase;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mynotes.Models.Notes;

import java.util.List;

@Dao
public interface MainDAO {

    @Insert (onConflict = REPLACE)
     void insert (Notes notes);

    @Query("SELECT * FROM notes ORDER BY ID DESC")
    List<Notes> getAll();

    @Query("UPDATE notes SET title = :title, notes = :notes WHERE ID = :ID")
    void update (int ID, String title, String notes);

    @Delete
    void delete (Notes notes);
}