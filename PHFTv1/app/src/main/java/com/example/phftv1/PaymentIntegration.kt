package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PaymentIntegration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment_integration)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//        findViewById<Button>(R.id.back_button_payment).setOnClickListener {
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
        findViewById<Button>(R.id.subscription_button).setOnClickListener {
            val intent = Intent(this, Subscription::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.card_payment_button).setOnClickListener {
            val intent = Intent(this, cardInput::class.java)
            startActivity(intent)
        }

        // Back button functionality
        findViewById<Button>(R.id.back_button_payment).setOnClickListener {
            finish() // Close the current activity and go back
        }

        // Purchase Workout Plan button
        findViewById<Button>(R.id.workout_plan_button).setOnClickListener {
            selectPaymentMethod("Workout Plan", 29.99)
        }

        // Hire Trainer button
        findViewById<Button>(R.id.trainer_hire_button).setOnClickListener {
            selectPaymentMethod("Virtual Trainer", 49.99)
        }

        // Debit/Credit Card Payment button
//        findViewById<Button>(R.id.card_payment_button).setOnClickListener {
//            initiateCardPayment()
//        }

        // PayPal Payment button
        findViewById<Button>(R.id.paypal_payment_button).setOnClickListener {
            initiatePayPalPayment()
        }
    }

    private fun selectPaymentMethod(item: String, price: Double) {
        Toast.makeText(this, "Selected $item - $$price", Toast.LENGTH_SHORT).show()
    }

    private fun initiateCardPayment() {
        Toast.makeText(this, "Initiating Card Payment...", Toast.LENGTH_SHORT).show()
        // Integrate card payment gateway logic here
    }

    private fun initiatePayPalPayment() {
        Toast.makeText(this, "Initiating PayPal Payment...", Toast.LENGTH_SHORT).show()
        // Integrate PayPal payment gateway logic here
    }
    }
