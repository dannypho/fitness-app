package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.Controller.RegistrationController

class UserPersonalInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_personal_information)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val ageEditText = findViewById<EditText>(R.id.age_inputGeneral)
        val weightEditText = findViewById<EditText>(R.id.weight_inputGeneral)
        val heightEditText = findViewById<EditText>(R.id.height_inputGeneral)

        findViewById<Button>(R.id.signup_btnGeneral).setOnClickListener {
            val age = ageEditText.text.toString().toInt()
            val weight = weightEditText.text.toString().toInt()
            val height = heightEditText.text.toString().toInt()
            RegistrationController().setProfile(age,weight,height)
        }



        findViewById<Button>(R.id.back_btnGeneral).setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}