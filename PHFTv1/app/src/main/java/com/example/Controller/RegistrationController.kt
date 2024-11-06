package com.example.Controller

import android.util.Log
import com.example.Model.GlobalConstants
import com.example.Model.User
import java.util.UUID

class RegistrationController  {
    final var currentUser: User = User()
    // Register a new user
   public fun registerUser(userName: String, password:String, name:String ) {
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
                currentUser = user
            }
        }
return user
    }

    fun addGuestUser(name:String, age:Int, weight:Int, height:Int){
        val user: User = User()
        user.id = UUID.randomUUID().toString()
        user.name = name
        user.role = GlobalConstants.GUEST
        user.attributes[GlobalConstants.AGE] = age
        user.attributes[GlobalConstants.WEIGHT] = weight
        user.attributes[GlobalConstants.HEIGHT] = height
        currentUser = user
    }
    fun setProfile(age:Int, weight:Int, height:Int){
        currentUser.attributes[GlobalConstants.AGE] = age
        currentUser.attributes[GlobalConstants.WEIGHT] = weight
        currentUser.attributes[GlobalConstants.HEIGHT] = height
    }

    // Logout a user
    fun logout() {
        currentUser = User()
    }


}