package com.example.smartparkingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper2 extends    SQLiteOpenHelper{
    public static final String DBNAME = "parkingslots.db";
    public static final String TABLE_NAME = "slots";
    public DBHelper2(@Nullable Context context) {
        super(context,"parkingslots.db",null,1);
    }
    private static final String slotname = "slotname";
    private static final String starttime = "starttime";
    private static final String endtime = "endtime";
    private static final String date = "date";
    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("Create table slots (slotno varchar(20) PRIMARY KEY,slotname varchar(20),startime varchar(20),endtime varchar(20),date varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists slots");
    }




    public Boolean insertData(String slotno ,String slotname,String startime,String endtime ,String date){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("slotno",slotno);
        contentValues.put("slotname",slotname);
        contentValues.put("startime", startime);
        contentValues.put("endtime",endtime);
        contentValues.put("date",date);
        long result = MyDB.insert("slots", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkslot(String slotno) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from slots where slotno = ?", new String[]{slotno});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    // Get User Details based on userid
    public ArrayList<HashMap<String, String>> GetSlotDetails() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query= "Select slotname,starttime,endtime,date FROM"+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()) {
            HashMap<String, String> user = new HashMap<>();
            user.put("name", cursor.getString(cursor.getColumnIndex(slotname)));
            user.put("starttime", cursor.getString(cursor.getColumnIndex(starttime)));
            user.put("endtime", cursor.getString(cursor.getColumnIndex(endtime)));
            user.put("date", cursor.getString(cursor.getColumnIndex(date)));
            userList.add(user);
        }
        return userList;
    }


}