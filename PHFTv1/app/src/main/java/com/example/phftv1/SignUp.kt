package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.Controller.RegistrationController
import com.example.backend.DataBaseHelper


class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        val usernameEditText = findViewById<EditText>(R.id.UserName_input)
        val  nameEditText = findViewById<EditText>(R.id.fullname_input)
        val passwordEditText = findViewById<EditText>(R.id.password_input)

        findViewById<Button>(R.id.onBackToLogin).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.signup_btn).setOnClickListener {
            val dbHelper = DataBaseHelper(this)
            val name = nameEditText.text.toString()
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            RegistrationController().registerUser(username,password,name,dbHelper)
            val intent = Intent(this, UserPersonalInformation::class.java)
            startActivity(intent)
        }


    }
}