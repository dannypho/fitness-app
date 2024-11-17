package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.Controller.RegistrationController
import com.example.Model.ROLES
import com.example.backend.DataBaseHelper
import com.example.backend.SessionManager

class UpdateUserInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_personal_information)
        val ageEditText = findViewById<EditText>(R.id.age_inputGeneral)
        val heightEditText = findViewById<EditText>(R.id.height_inputGeneral)
        val weightEditText = findViewById<EditText>(R.id.weight_inputGeneral)
        val profile_photo = findViewById<ImageView>(R.id.profile_photo)

        findViewById<Button>(R.id.update_info).setOnClickListener {
            val dbHelper = DataBaseHelper(this)
            if(SessionManager.currentUser.role != ROLES.GUEST){
                SessionManager.currentUser.age = ageEditText.text.toString().toInt()
                SessionManager.currentUser.weight = weightEditText.text.toString().toInt()
                SessionManager.currentUser.height = heightEditText.text.toString().toInt()
                dbHelper.updateUser(SessionManager.currentUser)
                val intent = Intent(this, Dashboard::class.java)
                startActivity(intent)
            }
            else{
                SessionManager.currentUser.age = ageEditText.text.toString().toInt()
                SessionManager.currentUser.weight = weightEditText.text.toString().toInt()
                SessionManager.currentUser.height = heightEditText.text.toString().toInt()
                val intent = Intent(this, Dashboard::class.java)
                startActivity(intent)
            }

        }


    }
}