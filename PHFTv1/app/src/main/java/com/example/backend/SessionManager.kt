package com.example.backend

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
        currentUser.attributes = user.attributes
    }

    fun logout() {
        currentUser = User()  // Reset to default or guest user
    }

    fun isLoggedIn(): Boolean = currentUser.id.isNotEmpty()
}
