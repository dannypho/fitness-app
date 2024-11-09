package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Subscription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_subscription)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

//        findViewById<Button>(R.id.back_button_subscription).setOnClickListener {
//            val intent = Intent(this, Dashboard::class.java)
//            startActivity(intent)
//        }
        // Back button functionality
        findViewById<Button>(R.id.back_button_subscription).setOnClickListener {
            finish() // Close the current activity and go back
        }

        // Monthly Subscription button
        findViewById<Button>(R.id.subscribe_monthly_button).setOnClickListener {
            Toast.makeText(this, "Monthly Subscription Activated", Toast.LENGTH_SHORT).show()
            // Handle subscription logic here (e.g., open payment screen)
        }

        // Annual Subscription button
        findViewById<Button>(R.id.subscribe_annual_button).setOnClickListener {
            Toast.makeText(this, "Annual Subscription Activated", Toast.LENGTH_SHORT).show()
            // Handle subscription logic here (e.g., open payment screen)
        }


    }
}