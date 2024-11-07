package com.example.backend

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.Model.User


open class DataBaseHelper(context: Context,
                          dbName: String = "phft.db",
                          version: Int = 1,
) : SQLiteOpenHelper(context, dbName, null, version) {

    companion object {
        // Users table constants
        const val USER_TABLE = "users"
        const val COLUMN_USER_ID = "column_user_id"
        const val COLUMN_NAME = "column_name"
        const val COLUMN_PASSWORD = "column_password"
        const val COLUMN_POINTS = "column_points"
        const val COLUMN_LEVEL = "column_level"
        const val COLUMN_ROLE = "column_role"

        //Goals table constants
        const val GOALS_TABLE = "goals"
        const val COLUMN_GOAL_ID = "column_goal_id"
        const val COLUMN_GOAL_TEXT = "column_goal_text"
        const val COLUMN_USER_FK = "column_user_id"
    }

    // Create the users table with the given columns
    override fun onCreate(db: SQLiteDatabase?) {
        // Users table constants
        val createUserTable = "CREATE TABLE $USER_TABLE (" +
                "$COLUMN_USER_ID TEXT PRIMARY KEY, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_PASSWORD TEXT, " +
                "$COLUMN_POINTS INT, " +
                "$COLUMN_LEVEL TEXT, " +
                "$COLUMN_ROLE TEXT)"

        db?.execSQL(createUserTable)

        // Goals table constants
        val createGoalsTable = "CREATE TABLE $GOALS_TABLE (" +
                "$COLUMN_GOAL_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_GOAL_TEXT TEXT, " +
                "FOREIGN KEY($COLUMN_USER_FK) REFERENCES $USER_TABLE($COLUMN_USER_ID))"

        db?.execSQL(createGoalsTable)
    }

    // Database schema shouldn't change. Ignore this method
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE $USER_TABLE")
        db?.execSQL("DROP TABLE $GOALS_TABLE")
        onCreate(db)
    }

    // Add a user to the users table
    fun addUser(user: User): Boolean {

        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COLUMN_USER_ID, user.id)
        cv.put(COLUMN_NAME, user.name)
        // cv.put(COLUMN_PASSWORD, user.)
        cv.put(COLUMN_POINTS, user.points)
        cv.put(COLUMN_LEVEL, user.level)
        cv.put(COLUMN_ROLE, user.role)

        val insert = db.insert(USER_TABLE, null, cv)

        return insert != -1L
    }

    // Add a goal to the goals table
    fun addGoal(userID: String, goal: String): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COLUMN_USER_FK, userID)
        cv.put(COLUMN_GOAL_TEXT, goal)

        val insert = db.insert(GOALS_TABLE, null, cv)

        return insert != -1L
    }

    // Read the goals table and return a list of the goals for a specific userID
    fun getGoalsForUser(userId: String): List<String> {
        val db = this.readableDatabase
        val query = "SELECT $COLUMN_GOAL_TEXT FROM $GOALS_TABLE WHERE $COLUMN_USER_FK = ?"
        val cursor: Cursor = db.rawQuery(query, arrayOf(userId))
        val goals = mutableListOf<String>()

        // Loop through the cursor to extract data
        if (cursor.moveToFirst()) {
            do {
                val goalText = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_GOAL_TEXT))
                // Store goal text in the goals list
                goals.add(goalText)
            } while (cursor.moveToNext())
        }
        cursor.close()

        return goals
    }

}