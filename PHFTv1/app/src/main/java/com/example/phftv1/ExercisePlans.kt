package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExercisePlans : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_exercise_plans)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

//        findViewById<Button>(R.id.back_button_exercise).setOnClickListener {
//            val intent = Intent(this, Dashboard::class.java)
//            startActivity(intent)
//        }

        // Back button functionality
        findViewById<Button>(R.id.back_button_exercise).setOnClickListener {
            finish() // Closes the current activity and goes back
        }

        // Set up buttons for pre-set routines
        setupPresetRoutineButtons()

        // Set up button for creating a custom workout plan
        findViewById<Button>(R.id.create_custom_plan_button).setOnClickListener {
            Toast.makeText(this, "Creating Custom Plan...", Toast.LENGTH_SHORT).show()
            // Navigate to a custom workout creation screen (not yet implemented)
        }
    }

    private fun setupPresetRoutineButtons() {
        findViewById<Button>(R.id.preset_routine_yoga).setOnClickListener {
            Toast.makeText(this, "Yoga Routine Selected", Toast.LENGTH_SHORT).show()
            // Show Yoga routine details or start the routine
        }

        findViewById<Button>(R.id.preset_routine_hiit).setOnClickListener {
            Toast.makeText(this, "HIIT Routine Selected", Toast.LENGTH_SHORT).show()
            // Show HIIT routine details or start the routine
        }

        findViewById<Button>(R.id.preset_routine_weightlifting).setOnClickListener {
            Toast.makeText(this, "Weightlifting Routine Selected", Toast.LENGTH_SHORT).show()
            // Show Weightlifting routine details or start the routine
        }
    }
}