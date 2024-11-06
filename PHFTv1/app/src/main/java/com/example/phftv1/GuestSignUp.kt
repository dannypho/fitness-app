package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Controller.RegistrationController
import com.example.Model.User

class GuestSignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_guest_sign_up)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val usernameEditText = findViewById<EditText>(R.id.name_input)
        val ageEditText = findViewById<EditText>(R.id.age_input)
        val weightEditText = findViewById<EditText>(R.id.weight_input)
        val heightEditText = findViewById<EditText>(R.id.height_input)

        findViewById<Button>(R.id.signup_btn).setOnClickListener {
            val name = usernameEditText.text.toString()
            val age = ageEditText.text.toString().toInt()
            val weight = weightEditText.text.toString().toInt()
            val height = heightEditText.text.toString().toInt()
            RegistrationController().addGuestUser(name, age, weight, height)
        }



            findViewById<Button>(R.id.back_btnGuest).setOnClickListener {
            val intent = Intent(this, GuestUser::class.java)
            startActivity(intent)
        }


    }
}