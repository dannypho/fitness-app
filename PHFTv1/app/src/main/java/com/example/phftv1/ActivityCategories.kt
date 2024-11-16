package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityCategories : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_categories)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        findViewById<Button>(R.id.dash_button).setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.progress_button).setOnClickListener {
            val intent = Intent(this, ProgressMonitoring::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.share_button).setOnClickListener {
            val intent = Intent(this, SocialFeatures::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.back_buttonCAT).setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

        // Set up button listeners for each activity category
        findViewById<Button>(R.id.running_button).setOnClickListener {
            // Handle running button click
            Toast.makeText(this, "Running selected", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.walking_button).setOnClickListener {
            // Handle walking button click
            Toast.makeText(this, "Walking selected", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.cycling_button).setOnClickListener {
            // Handle cycling button click
            Toast.makeText(this, "Cycling selected", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.yoga_button).setOnClickListener {
            // Handle yoga button click
            Toast.makeText(this, "Yoga selected", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.hiit_button).setOnClickListener {
            // Handle HIIT button click
            Toast.makeText(this, "HIIT selected", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.weightlifting_button).setOnClickListener {
            // Handle weightlifting button click
            Toast.makeText(this, "Weightlifting selected", Toast.LENGTH_SHORT).show()
        }

        // Add new activity button functionality (placeholder for future implementation)
        findViewById<Button>(R.id.add_activity_button).setOnClickListener {
            // TODO: Implement logic to add new activity types
            Toast.makeText(this, "Add new activity type clicked", Toast.LENGTH_SHORT).show()
        }

        // Create workout plan button functionality (placeholder for future implementation)
        findViewById<Button>(R.id.create_workout_button).setOnClickListener {
            // TODO: Implement logic to create a workout plan for trainers
            Toast.makeText(this, "Create workout plan clicked", Toast.LENGTH_SHORT).show()
        }  // TODO: Implement logic to create a workout plan for trainers



    }
}