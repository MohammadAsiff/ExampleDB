package com.example.utsav.exampledb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExampleDB extends SQLiteOpenHelper {
    private static final String DATABASE="sample_db";
    private  static final String TABLE_NAME="employee";
    public  static  final  String FIRST_NAME="first";
    public  static final  String LAST_NAME="last";
    public ArrayList<Map<String,String>> getDatafromDatabase;
    public ExampleDB(Context context) {
        super(context,DATABASE,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( "Create table "+TABLE_NAME +"("+FIRST_NAME+" TEXT,"+LAST_NAME+" TEXT"+")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL( "DROP TABLE IF EXISTS "+TABLE_NAME );
        onCreate( sqLiteDatabase );
    }
    public void  insert(String s1,String s2)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues(  );
        contentValues.put( FIRST_NAME,s1 );
        contentValues.put( LAST_NAME,s2 );
        sqLiteDatabase.insert( TABLE_NAME,null,contentValues );
    }

    public ArrayList<Map<String, String>> getDatafromDatabase() {
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        ArrayList<Map<String,String>> data=new ArrayList <>(  );
        Cursor cursor=sqLiteDatabase.rawQuery( "SELECT*FROM "+TABLE_NAME,null );
        if (cursor != null && cursor.moveToFirst()){

            while(!cursor.isAfterLast()){
                Map<String, String> map = new HashMap<>();
                map.put(FIRST_NAME, cursor.getString(cursor.getColumnIndex(FIRST_NAME)));
                map.put(LAST_NAME, cursor.getString(cursor.getColumnIndex(LAST_NAME)));
                data.add(map);
                cursor.moveToNext();
            }
        }
        return data;


    }
}
