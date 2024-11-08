package com.example.Controller

import android.util.Log
import com.example.Model.GlobalConstants
import com.example.Model.User
import com.example.backend.DataBaseHelper
import com.example.backend.SessionManager
import java.util.UUID

class RegistrationController  {
    final var currentUser: User = User()
    // Register a new user
   public fun registerUser(userName: String, password:String, name:String,dbHelper:DataBaseHelper ) {
        val user:User = User()
        user.id = UUID.randomUUID().toString()
        user.name = name
        user.role = GlobalConstants.GENERAL
        dbHelper.addUser(user)
        dbHelper.addLoginInfo(userName,password,user.id)
        SessionManager.loginUser(user)


    }

    // Login a user
    fun login(userName: String, password:String, dbHelper:DataBaseHelper) {
        var user:User = User()
        if (dbHelper.getUID(userName)!= ""){
            if(dbHelper.verifyLogin(userName,password)){
                user = dbHelper.getUserByUsername(userName)
                SessionManager.loginUser(user)
            }
        }
    }

    fun addGuestUser(name:String, age:Int, weight:Int, height:Int){
        val user: User = User()
        user.id = UUID.randomUUID().toString()
        user.name = name
        user.role = GlobalConstants.GUEST
        user.attributes[GlobalConstants.AGE] = age
        user.attributes[GlobalConstants.WEIGHT] = weight
        user.attributes[GlobalConstants.HEIGHT] = height
        SessionManager.loginUser(user)
    }
    fun setProfile(age:Int, weight:Int, height:Int, dbHelper:DataBaseHelper){
        SessionManager.currentUser.attributes[GlobalConstants.AGE] = age
        SessionManager.currentUser.attributes[GlobalConstants.WEIGHT] = weight
        SessionManager.currentUser.attributes[GlobalConstants.HEIGHT] = height
        dbHelper.updateUser(SessionManager.currentUser)
    }

    // Logout a user
    fun logout() {
        SessionManager.logout()
    }


}