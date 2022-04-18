package com.example.roomdatabasepratice;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "testdb")
public class Test {
    @PrimaryKey
    @ColumnInfo(name = "studentid")
    private int ID;

    @ColumnInfo(name = "text")
    private String Text;

    public Test(@NonNull int ID, String text) {
        this.ID = ID;
        Text = text;
    }
    @NonNull
    public int getID() {
        return ID;
    }

    public void setID(@NonNull int ID) {
        this.ID = ID;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
