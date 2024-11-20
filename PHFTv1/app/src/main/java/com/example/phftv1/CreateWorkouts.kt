package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.backend.DataBaseHelper


class CreateWorkouts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_workouts)

        val usernameInput = findViewById<EditText>(R.id.et_name_input)
        val workoutInput = findViewById<EditText>(R.id.et_workout_input)
        val submitButton = findViewById<Button>(R.id.submit_workout_button)

        submitButton.setOnClickListener {
            try {
                val username = usernameInput.text.toString()
                val workout = workoutInput.text.toString()

                // Check if username or workout is empty
                if (username.isEmpty()) {
                    Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (workout.isEmpty()) {
                    Toast.makeText(this, "Workout is required", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val dataBaseHelper = DataBaseHelper(this)

                // Check if name exists in database
                if (dataBaseHelper.getUID(username) == "null") {
                    Toast.makeText(this, "Username does not exist", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                else {
                    dataBaseHelper.submitWorkout(username, workout)
                    Toast.makeText(this, "Workout for $username created", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }
            catch (e: Exception) {
                Toast.makeText(this, "Error creating workout", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

        findViewById<Button>(R.id.back_buttonTRACKING).setOnClickListener {
            val intent = Intent(this, PersonalTrainerDashboard::class.java)
            startActivity(intent)
        }
    }
}
