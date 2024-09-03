package com.example.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DBHelper dbHelper;
    public DBManager(Context context){
        dbHelper = new DBHelper(context);
    }
    public long insertData(String value)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //contentvalues?
        ContentValues values=new ContentValues();
        values.put("name",value);
        long id = db.insert("my_table",null,values);
        db.close();
        return id;
    }
//    public long insertData(String name)
//    {
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        //contentvalues?
//        ContentValues values=new ContentValues();
//        values.put("name",name);
//        long id = db.insert("my_table",null,values);
//        db.close();
//        return id;
//    }

//    public Cursor getData(){
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        Cursor cursor =  db.rawQuery("SELECT * FROM my_table",null);
//        return cursor;
//    }
    public Cursor findData(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor =  db.rawQuery("SELECT * FROM my_table ORDER BY id DESC LIMIT 1",null);
        return cursor;
    }

//    public void deleteAllData(){
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.delete("my_table",null,null);
//        db.close();
//    }
}
