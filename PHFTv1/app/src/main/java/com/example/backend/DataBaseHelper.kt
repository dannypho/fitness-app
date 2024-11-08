package com.example.backend

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.Model.User


open class DataBaseHelper(context: Context,
                          dbName: String = "phft.db",
                          version: Int = 1,
) : SQLiteOpenHelper(context, dbName, null, version) {

    companion object {
        // Login information table constants
        const val LOGIN_TABLE = "Login_Information"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_PASSWORD = "password"

        // Users table constants
        const val USER_TABLE = "Users"
        const val COLUMN_USER_ID = "user_id"
        const val COLUMN_NAME = "name"
        const val COLUMN_POINTS = "points"
        const val COLUMN_LEVEL = "level"
        const val COLUMN_ROLE = "role"
        const val COLUMN_AGE = "age"
        const val COLUMN_WEIGHT = "weight"
        const val COLUMN_HEIGHT = "height"

        // Goals table constants
        const val GOALS_TABLE = "Goals"
        const val COLUMN_GOAL_ID = "goal_id"
        const val COLUMN_GOAL = "goal"
    }

    // Create the users table with the given columns
    override fun onCreate(db: SQLiteDatabase?) {
        // Enable foreign keys
        db?.execSQL("PRAGMA foreign_keys = ON")

        // Create login information table
        val createLoginTable ="CREATE TABLE $LOGIN_TABLE(" +
                "$COLUMN_USERNAME TEXT PRIMARY KEY, " +
                "$COLUMN_NAME TEXT NOT NULL, " +
                "$COLUMN_PASSWORD TEXT NOT NULL)"

        db?.execSQL(createLoginTable)

        // Create user table
        val createUserTable = "CREATE TABLE $USER_TABLE (" +
                "$COLUMN_USER_ID TEXT PRIMARY KEY, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_POINTS INT, " +
                "$COLUMN_LEVEL TEXT, " +
                "$COLUMN_AGE TEXT, " +
                "$COLUMN_WEIGHT TEXT, " +
                "$COLUMN_HEIGHT TEXT)"

        db?.execSQL(createUserTable)

        // Create goals table
        val createGoalsTable = "CREATE TABLE $GOALS_TABLE (" +
                "$COLUMN_GOAL_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_USER_ID TEXT, " +
                "$COLUMN_GOAL TEXT, " +
                "FOREIGN KEY($COLUMN_USER_ID) REFERENCES $USER_TABLE($COLUMN_USER_ID))"

        db?.execSQL(createGoalsTable)
    }

    // Database schema shouldn't change. Ignore this method
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE $USER_TABLE")
        db?.execSQL("DROP TABLE $GOALS_TABLE")
        db?.execSQL("DROP TABLE $LOGIN_TABLE")
        onCreate(db)
    }

    // Add a user to the users table
    fun addUser(user: User): Boolean {

        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COLUMN_USER_ID, user.id)
        cv.put(COLUMN_NAME, user.name)
        cv.put(COLUMN_LEVEL, user.level)
        cv.put(COLUMN_POINTS, user.points)
        cv.put(COLUMN_ROLE, user.role)
//        cv.put(COLUMN_AGE, user.age)
//        cv.put(COLUMN_WEIGHT, user.weight)
//        cv.put(COLUMN_HEIGHT, user.height)

        val insert = db.insert(USER_TABLE, null, cv)

        return insert != -1L
    }

    // Add a goal to the goals table
    fun addGoal(userID: String, goal: String): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COLUMN_USER_ID, userID)
        cv.put(COLUMN_GOAL, goal)

        val insert = db.insert(GOALS_TABLE, null, cv)

        return insert != -1L
    }

    // Read the goals table and return a list of the goals for a specific userID
    fun getGoalsForUser(userId: String): List<String> {
        val goals = mutableListOf<String>()
        val db = this.readableDatabase

        // Query to get all goals from a user_id
        val cursor = db.rawQuery("SELECT $COLUMN_GOAL FROM $GOALS_TABLE WHERE $COLUMN_USER_ID = ?", arrayOf(userId))

        // Loop through the cursor to extract data
        if (cursor.moveToFirst()) {
            do {
                val goalText = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_GOAL))
                // Store goal text in the goals list
                goals.add(goalText)
            } while (cursor.moveToNext())
        }
        cursor.close()

        return goals
    }

    fun verifyLogin(username: String, password: String): Boolean {
        val db = this.readableDatabase
        var dbPassword: String? = null

        try {
            val cursor = db.rawQuery("SELECT $COLUMN_PASSWORD FROM $LOGIN_TABLE WHERE $COLUMN_USERNAME = ?", arrayOf(username))

            // Get the dbPassword
            if (cursor.moveToFirst()) {
                dbPassword = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD))
            }
            cursor.close()
        } catch (e: SQLiteException) {
            Log.e("DatabaseError", "Invalid query: ${e.message}")
            return false
        }
        return dbPassword == password
    }
}