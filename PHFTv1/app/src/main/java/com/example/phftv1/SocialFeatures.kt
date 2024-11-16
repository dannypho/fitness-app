package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SocialFeatures : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_social_features)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }


//        findViewById<Button>(R.id.back_button_social).setOnClickListener {
//            val intent = Intent(this, ProgressMonitoring::class.java)
//            startActivity(intent)
//        }



        // Back button functionality
        findViewById<Button>(R.id.back_button_social).setOnClickListener {
            finish() // Close the current activity and go back
        }

        // Share Achievement button
        findViewById<Button>(R.id.share_achievement_button).setOnClickListener {
            shareAchievement()
        }

        // Compete in Challenges button
        findViewById<Button>(R.id.compete_challenge_button).setOnClickListener {
            competeInChallenges()
        }

        // Social Media Share button
        findViewById<Button>(R.id.share_to_social_button).setOnClickListener {
            postToSocialMedia()
        }
    }

    private fun shareAchievement() {
        // Logic to share fitness achievement (maybe using Firebase, API, etc.)
        Toast.makeText(this, "Fitness Achievement Shared!", Toast.LENGTH_SHORT).show()
    }

    private fun competeInChallenges() {
        // Logic to enter challenges (e.g. showing a list of challenges or creating one)
        Toast.makeText(this, "Competing in Challenge!", Toast.LENGTH_SHORT).show()
    }

    private fun postToSocialMedia() {
        // Logic to share a post on social media
        val textToShare = "I just achieved my fitness goal! #FitnessGoals #FitSyncApp"
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, textToShare)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}