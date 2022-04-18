package com.example.roomdatabasepratice;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TestDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Test test);

    @Delete
    void delete(Test test);

    @Delete
    void reset(List<Test> test);

    @Query("UPDATE testdb SET text = :sText WHERE ID = :sID")
    void update(int sID, String sText);

    @Query("SELECT * FROM testdb")
    List<Test> getAll();

}
