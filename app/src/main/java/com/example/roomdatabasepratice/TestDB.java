package com.example.roomdatabasepratice;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TestDAO.class},version=1,exportSchema = false)
public abstract class TestDB extends RoomDatabase {

    private static TestDB database;
    private static String DATABASE_NAME = "testdb";

    public synchronized static TestDB getInstance(Context context){
        if(database == null){
            database = Room.databaseBuilder(context.getApplicationContext()
            ,TestDB.class, DATABASE_NAME
            ).allowMainThreadQueries().
                    fallbackToDestructiveMigration().build();
        }
return database;
    }

    public abstract TestDAO testDAO();
}
