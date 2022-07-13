package com.example.smartparkingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends    SQLiteOpenHelper{
    public static final String DBNAME = "smartparking.db";
    public DBHelper(@Nullable Context context) {
        super(context,"smartparking.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
           MyDB.execSQL("Create table users ( id integer PRIMARY KEY AUTOINCREMENT,email varchar(20),username varchar(20),phone text,password varchar(20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }
    public Boolean insertData(String email,String username,String phone ,String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("email",email);
        contentValues.put("username", username);
        contentValues.put("phone",phone);
        contentValues.put("password",password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkusername(String email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where email = ?", new String[]{email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkuseremailpassword(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where email = ? and password = ?", new String[] {email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
