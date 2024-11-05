package com.example.Controller

import android.util.Log
import com.example.Model.GlobalConstants
import com.example.Model.User
import java.util.UUID

class RegistrationController  {
    // Register a new user
   public fun register(userName: String, password:String, name:String ) {
        var user:User = User()
        user.id = UUID.randomUUID().toString()
        user.name = name
        user.role = GlobalConstants.GENERAL
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

    fun addGuestUser(name:String, age:Int, weight:String, height:String){
        val user: User = User()
        user.id = UUID.randomUUID().toString()
        user.name = name
        user.role = GlobalConstants.GUEST
        user.attributes["age"] = age
        user.attributes["weight"] = weight
        user.attributes["height"] = height
        Log.i("User", user.toString())
    }

    // Logout a user
    fun logout() {}

    // Handle authentication for different roles
    fun authenticateUser() {}
}