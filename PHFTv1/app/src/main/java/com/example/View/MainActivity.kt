package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     setContentView(R.layout.activity_main)

        // Reference to the live data TextView
        val liveDataTextView: TextView = findViewById(R.id.liveDataTextView)

        // Set up live data
        val handler = android.os.Handler()
        val runnable = object : Runnable {
            override fun run() {
                val currentTime = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
                liveDataTextView.text = "$currentTime"
                handler.postDelayed(this, 1000) // Update every second
            }
        }
        handler.post(runnable)

        // Fetch the TextView for live date
        val liveDateTextView: TextView = findViewById(R.id.liveDateTextView)

        // Get the current date
        val currentDate = SimpleDateFormat("EEEE, MMMM d, yyyy", Locale.getDefault()).format(Date())

        // Set the current date
        liveDateTextView.text = currentDate

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