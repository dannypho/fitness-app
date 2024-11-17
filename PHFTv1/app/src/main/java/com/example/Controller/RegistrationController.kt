package com.example.Controller

import android.content.Context
import android.util.Log
import com.example.Model.ROLES
import com.example.Model.User
import com.example.backend.DataBaseHelper
import com.example.backend.SessionManager
import java.util.UUID

class RegistrationController  {


    // Register a new user
   public fun registerUserInfo(userName: String, password:String,dbHelper:DataBaseHelper ): User  {
        val user:User = User()
        user.id = UUID.randomUUID().toString()
        dbHelper.addLoginInfo(userName,password,user.id)
        return user
    }
    public fun registerUser(user: User,dbHelper:DataBaseHelper){
        dbHelper.addUser(user)
        SessionManager.loginUser(user)
    }

    // Login a user
    fun login(userName: String, password:String, dbHelper:DataBaseHelper): Boolean {
        var user:User = User()
        var isLoggedIn = false
        if (dbHelper.getUID(userName)!= ""){
            if(dbHelper.verifyLogin(userName,password)){
                user = dbHelper.getUserByUsername(userName)
                Log.i("UserInRegistration",user.toString())
                SessionManager.loginUser(user)
                Log.i("SessionManager", SessionManager.currentUser.toString())
                isLoggedIn = true
            }
        }
        return isLoggedIn
    }

    fun addGuestUser(name:String, age:Int, weight:Int, height:Int){
        val user: User = User()
        user.id = UUID.randomUUID().toString()
        user.name = name
        user.role = ROLES.GUEST
        user.age = age
        user.weight = weight
        user.height = height
        SessionManager.loginUser(user)
        Log.i("guest user",user.toString())

    }


    // Logout a user
    fun logout(context: Context) {
        SessionManager.logout(context)
    }


}