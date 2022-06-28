package com.example.vetapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import android.database.Cursor;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "HappyPaws.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE TABLE UserAccount(user_id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists UserAccount");
    }

    public boolean insertUserAccount(String email, String password) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("email", email);
        cv.put("password", password);
        long result = DB.insert("UserAccount", null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}
