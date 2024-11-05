package com.example.Controller

import com.example.Model.User

class UsersController {
   private val users: HashMap<String, User> = hashMapOf()

    public fun add(user: User, userName:String, password:String){
        users.put(user.id, user)
        SecurityController().addSignInInfo(user.id,userName,password)
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