package com.example.Model

data class User(
    var id: String = "",
    var name: String = "",
    var email: String = "",
    var password: String =  "",
    var level: String = " ",
    var points: Int = 0,
    var role: String = " ",
    var attributes: HashMap<String, Any> = hashMapOf(),
    var goals: HashMap<String, Any> = hashMapOf()
)