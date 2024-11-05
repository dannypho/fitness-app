package com.example.Controller

import com.example.Model.User
import java.util.UUID

class RegistrationController  {
    // Register a new user
    fun register(user: User,userName: String, password:String ) {
        user.id = UUID.randomUUID().toString()
        UsersController().add(user, userName, password)
    }

    // Login a user
    fun login(userName: String, password:String): User {
        var user:User = User()
        if (UsersController().getUID(userName)!= ""){
            if(SecurityController().isAuthenticated(userName, password)){
                user = UsersController().getUser(userName)
            }
        }
return user
    }

    // Logout a user
    fun logout() {}

    // Handle authentication for different roles
    fun authenticateUser() {}
}