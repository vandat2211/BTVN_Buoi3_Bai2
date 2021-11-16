package com.example.btvn_buoi5_bai1.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.btvn_buoi5_bai1.FilePDF;

import java.util.List;

@Dao
public interface FilePDFDAO {
    @Insert
    void insertFilePDF(FilePDF filePDF);

    @Query("SELECT * FROM FilePDF")
    List<FilePDF> getListFilePDF();
}
