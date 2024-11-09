package com.example.backend

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.Model.GlobalConstants
import com.example.Model.User
import com.example.backend.DataBaseHelper.Companion.COLUMN_PASSWORD
import com.example.backend.DataBaseHelper.Companion.COLUMN_USERNAME
import com.example.backend.DataBaseHelper.Companion.LOGIN_TABLE


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
                "$COLUMN_PASSWORD TEXT NOT NULL, " +
                "$COLUMN_USER_ID TEXT, " +
                "FOREIGN KEY($COLUMN_USER_ID) REFERENCES $USER_TABLE($COLUMN_USER_ID))"

        db?.execSQL(createLoginTable)

        // Create user table
        val createUserTable = "CREATE TABLE $USER_TABLE (" +
                "$COLUMN_USER_ID TEXT PRIMARY KEY, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_POINTS INT, " +
                "$COLUMN_LEVEL TEXT, " +
                "$COLUMN_ROLE TEXT, " +
                "$COLUMN_AGE INT, " +
                "$COLUMN_WEIGHT INT, " +
                "$COLUMN_HEIGHT INT)"

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
        cv.put(COLUMN_AGE, user.age)
        cv.put(COLUMN_WEIGHT, user.weight)
        cv.put(COLUMN_HEIGHT, user.height)
        Log.i("content values test:",cv.toString())

        val insert = db.insert(USER_TABLE, null, cv)
        Log.d("DatabaseOperation", "Insert result for addUser: $insert")
        return insert != -1L
    }

    // Add a goal to the goals table
    fun addGoal(userID: String, goal: String): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put(COLUMN_USER_ID, userID)
        cv.put(COLUMN_GOAL, goal)

        val insert = db.insert(GOALS_TABLE, null, cv)
        db.close()

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
        db.close()
        return dbPassword == password
    }

    fun getUserByUsername(userName: String): User {
        val db = this.readableDatabase
        var user: User = User()

        try {
            // Get the user ID using getUID method
            val userId = getUID(userName)

            // Query to get the full user details from USER_TABLE using userId
            val userQuery = "SELECT * FROM $USER_TABLE WHERE $COLUMN_USER_ID = ?"
            val userCursor = db.rawQuery(userQuery, arrayOf(userId))

            // Populate the User object if data is found
            if (userCursor.moveToFirst()) {
                user = User(
                    id = userCursor.getString(userCursor.getColumnIndexOrThrow(COLUMN_USER_ID)),
                    name = userCursor.getString(userCursor.getColumnIndexOrThrow(COLUMN_NAME)),
                    points = userCursor.getInt(userCursor.getColumnIndexOrThrow(COLUMN_POINTS)),
                    level = userCursor.getString(userCursor.getColumnIndexOrThrow(COLUMN_LEVEL)),
                    role = userCursor.getString(userCursor.getColumnIndexOrThrow(COLUMN_ROLE)),
                    age = userCursor.getInt(userCursor.getColumnIndexOrThrow(COLUMN_AGE)),
                    weight = userCursor.getInt(userCursor.getColumnIndexOrThrow(COLUMN_WEIGHT)),
                    height = userCursor.getInt(userCursor.getColumnIndexOrThrow(COLUMN_HEIGHT)),
                )
            }

            userCursor.close()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            db.close()
        }

        return user // Return null if no user is found
    }


    fun getUID(userName: String): String {
        val db = this.readableDatabase
        var userId: String? = null

        val query = "SELECT $COLUMN_USER_ID FROM $LOGIN_TABLE WHERE $COLUMN_USERNAME = ?"
        val cursor = db.rawQuery(query, arrayOf(userName))

        if (cursor.moveToFirst()) {
            userId = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USER_ID))
        }

        cursor.close()
        db.close()

        return userId ?: ""  // Return an empty string if userId is not found
    }

    fun updateUser(user: User): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()

        // Populate the ContentValues with the updated user details
        cv.put(COLUMN_NAME, user.name)
        cv.put(COLUMN_POINTS, user.points)
        cv.put(COLUMN_LEVEL, user.level)
        cv.put(COLUMN_ROLE, user.role)
        cv.put(COLUMN_AGE, user.age)
        cv.put(COLUMN_WEIGHT, user.weight)
        cv.put(COLUMN_HEIGHT, user.height)

        // Update the row and check if the operation was successful
        val rowsAffected = db.update(USER_TABLE, cv, "$COLUMN_USER_ID = ?", arrayOf(user.id))
        db.close()

        // Return true if at least one row was updated, otherwise false
        return rowsAffected > 0
    }

    fun addLoginInfo(username: String, password: String, UID: String) {
        val db = this.writableDatabase
        val cv = ContentValues()

        // Populate ContentValues with the login information
        cv.put(COLUMN_USERNAME, username)
        cv.put(COLUMN_PASSWORD, password)
        cv.put(COLUMN_USER_ID, UID)

        // Insert the login information into LOGIN_TABLE
         db.insert(LOGIN_TABLE, null, cv)

        // Close the database connection
        db.close()

    }



}

