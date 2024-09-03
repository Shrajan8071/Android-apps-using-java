package com.example.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "My_database";
    private static final int DATABASE_VERSION = 1;

//     Constructor

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db)
    {
//        String createTableQuery = "CREATE TABLE my_table(id INTEGER PRIMARY KEY AUTOINCREMENT,contact LONGINT,name TEXT)";
        String createTableQuery = "CREATE TABLE my_table(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT)";
        db.execSQL(createTableQuery);
    }

    //upgrade database if needed
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS my_table");
        onCreate(db);
    }

}
