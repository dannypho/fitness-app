package com.example.backend

import com.example.Model.User

object SessionManager {
    var currentUser: User = User()
        private set

    fun loginUser(user: User) {
        currentUser = user
    }

    fun logout() {
        currentUser = User()  // Reset to default or guest user
    }

    fun isLoggedIn(): Boolean = currentUser.id.isNotEmpty()
}
