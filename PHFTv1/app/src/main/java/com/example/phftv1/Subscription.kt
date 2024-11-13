//package com.example.phftv1
//
//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.LinearLayout
//import android.widget.Toast
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//
//
//class Subscription : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_subscription)
//
//
//        val adPanel = findViewById<LinearLayout>(R.id.ad_layout)
//
//        // Back button functionality
//        findViewById<Button>(R.id.back_button_subscription).setOnClickListener {
//            finish() // Close the current activity and go back
//        }
//
//        // Monthly Subscription button
//        findViewById<Button>(R.id.subscribe_monthly_button).setOnClickListener {
//            adPanel.setVisibility(View.GONE);
//            Toast.makeText(this, "Monthly Subscription Activated", Toast.LENGTH_SHORT).show()
//            // Handle subscription logic here (e.g., open payment screen)
//        }
//
//        // Annual Subscription button
//        findViewById<Button>(R.id.subscribe_annual_button).setOnClickListener {
//            adPanel.setVisibility(View.GONE);
//            Toast.makeText(this, "Annual Subscription Activated", Toast.LENGTH_SHORT).show()
//            // Handle subscription logic here (e.g., open payment screen)
//        }
//    }
//}

package com.example.phftv1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Subscription : AppCompatActivity() {

    private lateinit var adPanel: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_subscription)

        adPanel = findViewById(R.id.ad_layout)

        // Back button functionality
        findViewById<Button>(R.id.back_button_subscription).setOnClickListener {
            finish() // Close the current activity and go back
        }

        // Monthly Subscription button
        findViewById<Button>(R.id.subscribe_monthly_button).setOnClickListener {
            toggleAdPanelVisibility() // Toggle the visibility of the ad panel
            Toast.makeText(this, "Monthly Subscription Activated", Toast.LENGTH_SHORT).show()
            // Handle subscription logic here (e.g., open payment screen)
        }

        // Annual Subscription button
        findViewById<Button>(R.id.subscribe_annual_button).setOnClickListener {
            toggleAdPanelVisibility() // Toggle the visibility of the ad panel
            Toast.makeText(this, "Annual Subscription Activated", Toast.LENGTH_SHORT).show()
            // Handle subscription logic here (e.g., open payment screen)
        }
    }

    // Function to toggle the ad panel visibility
    private fun toggleAdPanelVisibility() {
        if (adPanel.visibility == View.VISIBLE) {
            adPanel.visibility = View.GONE
        } else {
            adPanel.visibility = View.VISIBLE
        }
    }
}
