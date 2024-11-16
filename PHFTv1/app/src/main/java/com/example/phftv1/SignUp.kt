//package com.example.phftv1
//
//import android.app.Activity
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import android.provider.MediaStore
//
//import android.widget.Button
//import android.widget.EditText
//import android.widget.ImageView
//import android.widget.Toast
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import com.example.Controller.RegistrationController
//import com.example.Model.ROLES
//import com.example.Model.User
//import com.example.backend.DataBaseHelper
//
//
//class SignUp : AppCompatActivity() {
//
//
//    private lateinit var profilePhoto: ImageView
//    private val PICK_IMAGE = 1
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_sign_up)
//        val usernameEditText = findViewById<EditText>(R.id.UserName_input)
//        val  nameEditText = findViewById<EditText>(R.id.fullname_input)
//        val passwordEditText = findViewById<EditText>(R.id.password_input)
//        profilePhoto = findViewById(R.id.profile_photo)
//        val ageEditText = findViewById<EditText>(R.id.age_inputGeneral)
//        val weightEditText = findViewById<EditText>(R.id.weight_inputGeneral)
//        val heightEditText = findViewById<EditText>(R.id.height_inputGeneral)
//
//        // Set up the profile photo upload button
//        findViewById<Button>(R.id.upload_photo_btn).setOnClickListener {
//            openGallery()
//        }
//
//
//
//        findViewById<Button>(R.id.onBackToLogin).setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//
//
//        // Sign-up button functionality
//        findViewById<Button>(R.id.signup_btn).setOnClickListener {
//            val dbHelper = DataBaseHelper(this)
//
//            //save user sign in info
//            val username = usernameEditText.text.toString()
//            val password = passwordEditText.text.toString()
//            val user:User = RegistrationController().registerUserInfo(username,password,dbHelper)
//
//            //save user
//            user.name = nameEditText.text.toString()
//            user.role = ROLES.GENERAL
//            user.age = ageEditText.text.toString().toIntOrNull() ?: 0
//            user.weight = weightEditText.text.toString().toIntOrNull() ?: 0
//            user.height = heightEditText.text.toString().toIntOrNull() ?: 0
//            RegistrationController().registerUser(user, dbHelper)
//
//            val intent = Intent(this, GeneralUser::class.java)
//            startActivity(intent)
//            Toast.makeText(this, "Login Using New Account", Toast.LENGTH_SHORT).show()
//
//        }
//    }
//
//
//private fun openGallery() {
//    val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
//    startActivityForResult(intent, PICK_IMAGE)
//}
//
//override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//    super.onActivityResult(requestCode, resultCode, data)
//    if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
//        val imageUri: Uri? = data.data
//        profilePhoto.setImageURI(imageUri)
//    }
//}
//}


package com.example.phftv1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Controller.RegistrationController
import com.example.backend.DataBaseHelper

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        findViewById<Button>(R.id.onBackToLogin ).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



        val usernameEditText = findViewById<EditText>(R.id.UserName_input)
        val nameEditText = findViewById<EditText>(R.id.fullname_input)
        val emailEditText = findViewById<EditText>(R.id.email_input)
        val passwordEditText = findViewById<EditText>(R.id.password_input)
        val confirmPasswordEditText = findViewById<EditText>(R.id.confirm_password_input)

        // Sign-up button functionality
        findViewById<Button>(R.id.signup_btn).setOnClickListener {
            val dbHelper = DataBaseHelper(this)

            // Validate Full Name
            val fullName = nameEditText.text.toString().trim()
            if (fullName.isEmpty()) {
                Toast.makeText(this, "Please enter your full name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validate Email Address
            val email = emailEditText.text.toString().trim()
            if (!email.matches(Regex("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$"))) {
                Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validate User ID
            val username = usernameEditText.text.toString().trim()
            if (username.length < 6 || !username.matches(Regex("^[a-zA-Z0-9]+$"))) {
                Toast.makeText(this, "User ID must be at least 6 characters and contain no special characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validate Password
            val password = passwordEditText.text.toString().trim()
            if (password.length < 8 || !password.matches(Regex(".*[0-9].*"))) {
                Toast.makeText(this, "Password must be at least 8 characters long and include a number and a special character", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validate Confirm Password
            val confirmPassword = confirmPasswordEditText.text.toString().trim()
            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // If all validations pass, save user information
            val user = RegistrationController().registerUserInfo(username, password, dbHelper)
            user.name = fullName
           // user.email = email

            // Call your method to save the user in the database
            RegistrationController().registerUser(user, dbHelper)

            // Show success message and navigate to another activity
            Toast.makeText(this, "Sign Up Successful.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }
}
