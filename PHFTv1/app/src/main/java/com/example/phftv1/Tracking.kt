package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tracking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tracking)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
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
        findViewById<Button>(R.id.back_buttonTRACKING).setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }




    }
}