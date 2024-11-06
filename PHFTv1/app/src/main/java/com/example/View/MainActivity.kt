package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     setContentView(R.layout.activity_main)



        // This btnGeneralUser is used in the welcome page to go the the login page
        findViewById<Button>(R.id.btnGeneralUser).setOnClickListener {
            val intent = Intent(this, GeneralUser::class.java)
            startActivity(intent)
        }
        // This btnGuestUser is used in the welcome page to go the the login page
        findViewById<Button>(R.id.btnGuestUser).setOnClickListener {
            val intent = Intent(this, GuestUser::class.java)
            startActivity(intent)
        }


        findViewById<Button>(R.id.btnSignUpUser).setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnPersonalTrainer).setOnClickListener {
            val intent = Intent(this, PersonalTrainer::class.java)
            startActivity(intent)
        }
    }
}