//package com.example.phftv1
//
//import android.os.Bundle
//import android.widget.Button
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//
//class leaderboard : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_leaderboard)
////        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
////            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
////            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
////            insets
////        }
//
//
//        findViewById<Button>(R.id.back_button_leaderboard).setOnClickListener {
//            finish() // Close the current activity and go back
//        }
//    }
//}

// leaderboard.kt
package com.example.phftv1

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class leaderboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_leaderboard)

        // Back button functionality
        findViewById<Button>(R.id.back_button_leaderboard).setOnClickListener {
            finish() // Close the current activity and go back
        }

        // Sample data for the leaderboard
        val leaderboardItems = listOf(
            LeaderboardItem(rank = 1, username = "Alice Johnson", points = 1500),
            LeaderboardItem(rank = 2, username = "Bob Smith", points = 1475),
            LeaderboardItem(rank = 3, username = "Charlie Brown", points = 1450),
            LeaderboardItem(rank = 4, username = "Diana Ross", points = 1425),
            LeaderboardItem(rank = 5, username = "Ethan Clark", points = 1400),
            LeaderboardItem(rank = 6, username = "Fiona Davis", points = 1375),
            LeaderboardItem(rank = 7, username = "George Miller", points = 1350),
            LeaderboardItem(rank = 8, username = "Hannah Wilson", points = 1325),
            LeaderboardItem(rank = 9, username = "Isabella Moore", points = 1300),
            LeaderboardItem(rank = 10, username = "Jack White", points = 1275),
            LeaderboardItem(rank = 11, username = "Karen Thompson", points = 1250),
            LeaderboardItem(rank = 12, username = "Liam Garcia", points = 1225),
            LeaderboardItem(rank = 13, username = "Mia Martinez", points = 1200),
            LeaderboardItem(rank = 14, username = "Noah Rodriguez", points = 1175),
            LeaderboardItem(rank = 15, username = "Olivia Lee", points = 1150),
            LeaderboardItem(rank = 16, username = "Paul Walker", points = 1125),
            LeaderboardItem(rank = 17, username = "Quincy Adams", points = 1100),
            LeaderboardItem(rank = 18, username = "Rachel Green", points = 1075),
            LeaderboardItem(rank = 19, username = "Samuel Harris", points = 1050),
            LeaderboardItem(rank = 20, username = "Tina Turner", points = 1025),
            LeaderboardItem(rank = 21, username = "Uma Patel", points = 1000),
            LeaderboardItem(rank = 22, username = "Victor Gomez", points = 975),
            LeaderboardItem(rank = 23, username = "Wendy Collins", points = 950),
            LeaderboardItem(rank = 24, username = "Xavier Lewis", points = 925),
            LeaderboardItem(rank = 25, username = "Yara Khan", points = 900),
            LeaderboardItem(rank = 26, username = "Zoe Kim", points = 875),
            LeaderboardItem(rank = 27, username = "Adam Wright", points = 850),
            LeaderboardItem(rank = 28, username = "Beth Parker", points = 825),
            LeaderboardItem(rank = 29, username = "Carlos Perez", points = 800),
            LeaderboardItem(rank = 30, username = "Daisy Bennett", points = 775)
        )



        // Set up RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.leaderboard_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = LeaderboardAdapter(leaderboardItems)
    }
}
