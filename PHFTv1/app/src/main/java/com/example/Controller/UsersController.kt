package com.example.Controller

import android.util.Log
import com.example.Model.User

class UsersController {
   private val users: HashMap<String, User> = hashMapOf()

    public fun add(user: User, userName:String, password:String){
        users[user.id] = user
        SecurityController().addSignInInfo(user.id,userName,password)
        Log.i("general user",user.toString())
        Log.i("users",users.toString())
    }
    public fun addGuest(user: User){
        users[user.id] = user
        Log.i("guest user", user.toString())
        Log.i("users", users.toString())
    }

    public fun getUID(userName:String): String {
        var UID:String = ""
        users.forEach { (t, u) -> if (u.name == userName) {
            UID = t
        }
        }
        return UID
    }
    public fun getUser(userName: String): User {
        val UID: String = getUID(userName)
        return users.getValue(UID)
    }


}