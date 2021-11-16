package com.example.btvn_buoi5_bai1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "FilePDF")
public class FilePDF {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    public FilePDF(String name) {
        this.name = name;
    }

    public FilePDF() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
