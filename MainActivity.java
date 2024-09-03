package com.projectedittor.SGSITS;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DBManager dbManager;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add=findViewById(R.id.add);
        Button minus=findViewById(R.id.minus);
        Button save=findViewById(R.id.save);
        Button fetch=findViewById(R.id.fetch);

        txt=findViewById(R.id.textView);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = txt.getText().toString();
                int x = Integer.parseInt(s);
                x=x+1;
                txt.setText(String.valueOf(x));
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = txt.getText().toString();
                int x = Integer.parseInt(s);
                x=x-1;
                txt.setText(String.valueOf(x));
            }
        });

        dbManager = new DBManager(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = txt.getText().toString();
                dbManager.insertData(s);
            }
        });

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayData();
            }
        });

//        dbManager = new DBManager(this);
//        textViewData = findViewById(R.id.textViewData);
//
//        //insert into the table
//        dbManager.insertData("Shrajan");
//        dbManager.insertData("Gupta");
//        dbManager.insertData("Bhopali");
//
//        displayData();
    }

    @SuppressLint("Range")
    public void displayData(){
        Cursor cursor = dbManager.findData();
        String name = null;
        while(cursor.moveToNext()){
             name=cursor.getString((cursor.getColumnIndex(("name"))));
        }
        txt.setText(name);
    }
    /*protected void onDestroy(){
        dbManager.deleteAllData();
        super.onDestroy();
    }*/

//    private void displayData(){
//        StringBuilder stringBuilder = new StringBuilder();
//        Cursor cursor = dbManager.getData();
//        while(cursor.moveToNext()){
//            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
//            @SuppressLint("Range") String name=cursor.getString((cursor.getColumnIndex(("name"))));
//            stringBuilder.append("ID").append(id).append(": Name: ").append(name).append("\n");
//        }
//        textViewData.setText((stringBuilder.toString()));
//    }
//    protected void onDestroy(){
//        dbManager.deleteAllData();
//        super.onDestroy();
//    }
}