package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RewardCenter : AppCompatActivity() {

    private var userPoints: Int = 0
    private var redeemedProducts: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reward_center)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        findViewById<Button>(R.id.back_button_reward_center).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


// Back button functionality
        findViewById<Button>(R.id.back_button_reward_center).setOnClickListener {
            finish() // Close the current activity and go back
        }

        // Initialize points and level
        updateUserPoints()

        // Daily Challenge button
        findViewById<Button>(R.id.daily_challenge_button).setOnClickListener {
            completeDailyChallenge()
        }

        // Leaderboard button
        findViewById<Button>(R.id.leaderboard_button).setOnClickListener {
//            viewLeaderboard()
            val intent = Intent(this, leaderboard::class.java)
            startActivity(intent)
        }

        // Browse Reward Products button
        findViewById<Button>(R.id.browse_products_button).setOnClickListener {
            browseRewardProducts()
        }

        // Redeem Points button
        findViewById<Button>(R.id.redeem_points_button).setOnClickListener {
            redeemPoints()
        }
    }

    private fun updateUserPoints() {
        findViewById<TextView>(R.id.user_points).text = "Your Points: $userPoints"
        findViewById<TextView>(R.id.user_level).text = getUserLevel()
        findViewById<TextView>(R.id.redeemed_products_list).text = redeemedProducts.joinToString(", ")
    }

    private fun getUserLevel(): String {
        return when {
            userPoints < 1000 -> "Silver"
            userPoints < 30000 -> "Gold"
            else -> "Diamond"
        }
    }

    private fun completeDailyChallenge() {
        userPoints += 50 // Reward points for completing a challenge
        Toast.makeText(this, "Daily Challenge Completed! You earned 50 points.", Toast.LENGTH_SHORT).show()
        updateUserPoints()
    }

    private fun viewLeaderboard() {
        Toast.makeText(this, "Viewing Leaderboard...", Toast.LENGTH_SHORT).show()
        // Implement leaderboard viewing functionality here
    }

    private fun browseRewardProducts() {
        Toast.makeText(this, "Browsing Reward Products...", Toast.LENGTH_SHORT).show()
        // Implement product browsing functionality here
    }

    private fun redeemPoints() {
        if (userPoints >= 100) {
            userPoints -= 100 // Deduct points for redeeming
            redeemedProducts.add("Workout Equipment") // Example redeemed product
            Toast.makeText(this, "You have redeemed points for a reward!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Not enough points to redeem!", Toast.LENGTH_SHORT).show()
        }
        updateUserPoints()





    }
}



