package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PresetExcerciePlan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preset_excercie_plan)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        findViewById<Button>(R.id.Pre_btn_back).setOnClickListener {
            finish()
        }
        // view preset weightlift routine
        findViewById<ImageView>(R.id.exercise_image6).setOnClickListener {
            val intent = Intent(this, PresetExcerciePlanWeightlifting::class.java)
            startActivity(intent)
        }
        findViewById<ImageView>(R.id.exercise_image7).setOnClickListener {
            val intent = Intent(this, PresetExcerciePlanYoga::class.java)
            startActivity(intent)
        }
        findViewById<ImageView>(R.id.exercise_image5).setOnClickListener {
            val intent = Intent(this, PresetExcerciePlanHIIT::class.java)
            startActivity(intent)
        }

    }
}