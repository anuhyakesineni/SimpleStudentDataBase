package com.example.simplestudentdatabase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context) : SQLiteOpenHelper(context,"StudentsDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE StudentDetails(Id INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR2,Age VARCHAR2)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {


    }
}





