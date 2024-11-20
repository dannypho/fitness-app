package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.backend.DataBaseHelper


class Workouts : AppCompatActivity() {

    private lateinit var  dbHelper: DataBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_workouts)

        dbHelper = DataBaseHelper(this)

        val showWorkout = findViewById<Button>(R.id.show_workout_button)

        showWorkout.setOnClickListener {
            val workout = dbHelper.getWorkout(global_username)
            if (workout != null) {
                Toast.makeText(this, workout, Toast.LENGTH_SHORT).show()
                val workoutInput = findViewById<EditText>(R.id.et_workout_input)
                workoutInput.setText(workout)
            }
            else {
                Toast.makeText(this, "No workout found for user: $global_username", Toast.LENGTH_SHORT).show()
            }
        }

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
        findViewById<Button>(R.id.back_buttonTRACKING).setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }
}
