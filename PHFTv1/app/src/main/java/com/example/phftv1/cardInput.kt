package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.text.InputFilter
import android.text.Spanned

class cardInput : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_card_input)



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


        // Card Number Input field (16 digits)
        val cardNumberInput = findViewById<EditText>(R.id.card_number_input)
        cardNumberInput.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(16))

        // CVV Input field (3 digits)
        val cvvInput = findViewById<EditText>(R.id.cvv_input)
        cvvInput.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(3))

        // Expiration Date Input field (MM/YY format)
        val expirationInput = findViewById<EditText>(R.id.expiration_input)
        expirationInput.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(5)) // MM/YY format

        // Button to submit the payment
        val submitPaymentButton = findViewById<Button>(R.id.submit_payment_button)
        submitPaymentButton.setOnClickListener {
            val cardNumber = cardNumberInput.text.toString().trim()
            val cvv = cvvInput.text.toString().trim()
            val expiration = expirationInput.text.toString().trim()

            if (validateCardInputs(cardNumber, cvv, expiration)) {
                // Proceed with payment processing or next step
                Toast.makeText(this, "Payment details are valid", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please check your card details", Toast.LENGTH_SHORT).show()
            }
        }

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    // Function to validate card number, CVV, and expiration date
    private fun validateCardInputs(cardNumber: String, cvv: String, expiration: String): Boolean {
        return when {
            cardNumber.length != 16 -> {
                Toast.makeText(this, "Card number must be 16 digits", Toast.LENGTH_SHORT).show()
                false
            }
            cvv.length != 3 -> {
                Toast.makeText(this, "CVV must be 3 digits", Toast.LENGTH_SHORT).show()
                false
            }
            !expiration.matches(Regex("^\\d{2}/\\d{2}$")) -> {
                Toast.makeText(this, "Expiration date must be in MM/YY format", Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }
    }
}
