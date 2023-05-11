// Created on April,2023 by Manpreet Kaur Sidhu
// class that will help to maintain database connection

package com.example.assignment6sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String NAME = "TravelExpertsSqlLite.db";
    private static final int VERSION= 1;

    public DBHelper(@Nullable Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.d("manpreet","db version onopen"+db.getVersion());
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("manpreet","db version");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("manpreet","db version upgrade");
    }
}
