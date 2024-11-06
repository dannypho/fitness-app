package com.example.Controller

import android.util.Log

class SecurityController {
    private val validationMap: HashMap<String, HashMap<String,String>> = hashMapOf()

     fun isAuthenticated(userName: String, password:String): Boolean {
        var isAuthenticated:Boolean =  false
        val UID:String = UsersController().getUID(userName)
        if(password == (validationMap[UID]?.get(userName) ?: "")){
            isAuthenticated = true;
        }
        return isAuthenticated
    }
    public fun addSignInInfo(UID:String, userName: String, password:String) {
// Check if there's already an inner map for UID, or create one if it doesn't exist
        val innerMap = validationMap.getOrPut(UID) { hashMapOf() }
// Add the userName and password to the inner map
        innerMap[userName] = password
    }

}