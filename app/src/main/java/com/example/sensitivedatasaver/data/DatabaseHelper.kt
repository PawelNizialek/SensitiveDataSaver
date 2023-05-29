package com.example.sensitivedatasaver.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

const val DATABASE_NAME = "AppDatabase"
const val TABLE_NAME = "users"

class DatabaseHelper(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TABLE_NAME(id integer primary key autoincrement," +
                "login varchar(30), password varchar(20), data1 varchar(100), data2 varchar(100)," +
                "data3 varchar(100), data4 varchar(100))")
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //onCreate(db);
    }

    fun insertUserData(login: String, password: String) {

        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("login", login)
        values.put("password", password)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun insertSensitiveData(data1: String, data2: String, data3: String) {
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("data1", data1)
        values.put("data2", data2)
        values.put("data3", data3)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun readSensitiveData(login: String, password: String) {
        val db = writableDatabase
        val query = "select * from $TABLE_NAME where login = $login and password = $password"
        val cursor = db.rawQuery(query, null)

        if(cursor.count <= 0){
            cursor.close()
        }
        cursor.close()
    }

    fun isUserPresent(login: String, password: String): Boolean {
        val db = writableDatabase
        val query = "select * from $TABLE_NAME where login = $login and password = $password"
        val cursor = db.rawQuery(query, null)

        if(cursor.count <= 0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
//    fun readData(): MutableList<User> {
//        val list: MutableList<User> = ArrayList()
//        val db = this.readableDatabase
//        val query = "Select * from $TABLE_NAME"
//        val result = db.rawQuery(query, null)
//        if (result.moveToFirst()) {
//            do {
//                val user = User()
//                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
//                user.name = result.getString(result.getColumnIndex(COL_NAME))
//                user.age = result.getString(result.getColumnIndex(COL_AGE)).toInt()
//                list.add(user)
//            }
//            while (result.moveToNext())
//        }
//        return list
//    }
}