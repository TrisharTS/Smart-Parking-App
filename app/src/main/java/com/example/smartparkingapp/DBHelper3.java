package com.example.smartparkingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper3 extends   SQLiteOpenHelper{
    public static final String DBNAME = "feedback.db";
    public DBHelper3(@Nullable Context context) {
        super(context,"feedback.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("Create table feedback (email varchar(20),name varchar(20),phone varchar(20),message varchar(100))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists feedback");
    }
    public Boolean insertData(String email, String name, String phone ,String message ){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("email",email);
        contentValues.put("name", name);
        contentValues.put("phone",phone);
        contentValues.put("message",message);
        long result = MyDB.insert("feedback", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
}
