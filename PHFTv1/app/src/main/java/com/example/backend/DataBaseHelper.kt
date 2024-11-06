package com.example.backend

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



open class DataBaseHelper(context: Context,
                          dbName: String = "phft.db",
                          version: Int = 1,
) : SQLiteOpenHelper(context, dbName, null, version) {

    companion object {
        const val USER_TABLE = "users"
        const val COLUMN_ID = "id"
        const val COLUMN_USERID = "column_userid"
        const val COLUMN_NAME = "column_name"
        const val COLUMN_PASSWORD = "column_password"
    }

    // Create the users table with the given columns
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableString = "CREATE TABLE $USER_TABLE (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_USERID INT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_PASSWORD TEXT)"
        db?.execSQL(createTableString)
    }

    // Database schema shouldn't change. onUpgrade doesn't need to be used
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE $USER_TABLE")
        onCreate(db)
    }

    // Add a user to the users table
    fun add(userid: Int, name: String, password: String): Boolean {

        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COLUMN_USERID, userid)
        cv.put(COLUMN_NAME, name)
        cv.put(COLUMN_PASSWORD, password)

        val insert = db.insert(USER_TABLE, null, cv)

        return insert != -1L
    }
}