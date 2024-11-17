package com.example.backend

import android.content.Context
import android.util.Log
import com.example.Model.User

object SessionManager {
    var currentUser: User = User()
        private set

    fun loginUser(user: User) {
        currentUser.id = user.id
        currentUser.name = user.name
        currentUser.points = user.points
        currentUser.level = user.level
        currentUser.role = user.role
        currentUser.age = user.age
        currentUser.weight = user.weight
        currentUser.height = user.height
    }

    fun logout(context: Context) {
        currentUser = User()  // Reset to default or guest user
        // Close database connection
        val dbHelper = DataBaseHelper(context)
        dbHelper.closeDatabase() // Ensure the database connection is closed
    }

    fun isLoggedIn(): Boolean = currentUser.id.isNotEmpty()
}
