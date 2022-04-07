package com.example.exp5databaseinas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

public class DB extends SQLiteOpenHelper {
    @RequiresApi(api = Build.VERSION_CODES.P)
    public DB(@Nullable Context context) {
        super(context,keys.DBNAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(keys.CREATE);
        System.out.println("SucessFully !!!");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(keys.DROP);
        onCreate(db);
    }
    public Boolean setData(String name){
        ContentValues values = new ContentValues();
        values.put("NAME",name);
        SQLiteDatabase db = this.getWritableDatabase();
        if (db.insert(keys.NAME,null,values)>0){
            db.close();
            return true;
        }
        else{
            db.close();
            return false;
        }
    }
    public ArrayList<String> getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+keys.NAME;
        Cursor cursor = db.rawQuery(query,null);
        ArrayList<String> data = new ArrayList<>();
        while (cursor.moveToNext()){
            data.add(cursor.getString(0));
        }
        cursor.close();
        return data;
    }
}
