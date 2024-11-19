package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.backend.SessionManager

class PersonalTrainerDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_personal_trainer_dashboard)
        findViewById<Button>(R.id.btn_back).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_check_roster).setOnClickListener {
            val intent = Intent(this, ActivityCategories::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_create_workout).setOnClickListener {
            val intent = Intent(this, CreateWorkouts::class.java)
            startActivity(intent)
        }


        findViewById<Button>(R.id.btn_manage_training).setOnClickListener {
            val intent = Intent(this, GoalSetting::class.java)
            startActivity(intent)
        }




    }
}