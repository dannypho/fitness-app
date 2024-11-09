package com.example.Model

data class User(
    var id: String = "",
    var name: String = "",
    var level: String = " ",
    var points: Int = 0,
    var role: String = " ",
    var age: Int = 0,
    var weight: Int = 0,
    var height: Int = 0,
    var goals: HashMap<String, Any> = hashMapOf()
)