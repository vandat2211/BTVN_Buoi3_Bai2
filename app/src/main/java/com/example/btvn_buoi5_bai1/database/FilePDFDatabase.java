package com.example.btvn_buoi5_bai1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.btvn_buoi5_bai1.FilePDF;

@Database(entities = {FilePDF.class}, version = 1)
public abstract class FilePDFDatabase extends RoomDatabase {

    /*static Migration migration_from_2_to_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //ALTER TABLE ten_bang ADD ten_cot dinh_nghia_cot;
            database.execSQL("ALTER TABLE user ADD COLUMN year TEXT");
        }
    };*/

    private static final String DATABASE_NAME = "filepdf.db";
    private static FilePDFDatabase instance;

    public static synchronized FilePDFDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), FilePDFDatabase.class, DATABASE_NAME).
                    allowMainThreadQueries()
                    .build();

        }
        return instance;
    }

    public abstract FilePDFDAO filePDFDAO();
}
