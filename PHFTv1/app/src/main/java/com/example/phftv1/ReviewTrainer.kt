package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewTrainer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_trainer)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }


//        findViewById<Button>(R.id.back_button_trainer_review).setOnClickListener {
//            val intent = Intent(this, Dashboard::class.java)
//            startActivity(intent)
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

        // Back button functionality
        findViewById<Button>(R.id.back_button_trainer_review).setOnClickListener {
            finish() // Close the current activity and go back
        }

        // Feedback input and rating bar
        val feedbackInput = findViewById<EditText>(R.id.feedback_input)
        val ratingBar = findViewById<RatingBar>(R.id.trainer_rating_bar)

        // Submit button functionality
        findViewById<Button>(R.id.submit_feedback_button).setOnClickListener {
            val feedbackText = feedbackInput.text.toString().trim()
            val rating = ratingBar.rating.toInt()

            if (feedbackText.isNotEmpty() && rating > 0) {
                // Handle feedback submission (e.g., save to database or server)
                Toast.makeText(this, "Thank you for your feedback!", Toast.LENGTH_SHORT).show()

                // Clear inputs
                feedbackInput.text.clear()
                ratingBar.rating = 0f
            } else {
                Toast.makeText(this, "Please provide a rating and feedback.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}