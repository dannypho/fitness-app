package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)


        findViewById<Button>(R.id.btn_back).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_activity_categories).setOnClickListener {
            val intent = Intent(this, ActivityCategories::class.java)
            startActivity(intent)
        }


        findViewById<Button>(R.id.btn_goal_setting).setOnClickListener {
            val intent = Intent(this, GoalSetting::class.java)
            startActivity(intent)
        }


        findViewById<Button>(R.id.btn_tracking).setOnClickListener {
            val intent = Intent(this, Tracking::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_progress_monitoring).setOnClickListener {
            val intent = Intent(this, ProgressMonitoring::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_exercise_plans).setOnClickListener {
            val intent = Intent(this, ExercisePlans::class.java)
            startActivity(intent)
        }


        findViewById<Button>(R.id.btn_trainer_reviews).setOnClickListener {
            val intent = Intent(this, ReviewTrainer::class.java)
            startActivity(intent)
        }



        findViewById<Button>(R.id.btn_subscription).setOnClickListener {
            val intent = Intent(this, Subscription::class.java)
            startActivity(intent)
        }



        findViewById<Button>(R.id.btn_reward_center).setOnClickListener {
            val intent = Intent(this, RewardCenter::class.java)
            startActivity(intent)
        }

    }
}