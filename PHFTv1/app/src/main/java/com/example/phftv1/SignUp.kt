package com.example.phftv1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore

import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.Controller.RegistrationController
import com.example.Model.ROLES
import com.example.Model.User
import com.example.backend.DataBaseHelper


class SignUp : AppCompatActivity() {


    private lateinit var profilePhoto: ImageView
    private val PICK_IMAGE = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        val usernameEditText = findViewById<EditText>(R.id.UserName_input)
        val  nameEditText = findViewById<EditText>(R.id.fullname_input)
        val passwordEditText = findViewById<EditText>(R.id.password_input)
        profilePhoto = findViewById(R.id.profile_photo)
        val ageEditText = findViewById<EditText>(R.id.age_inputGeneral)
        val weightEditText = findViewById<EditText>(R.id.weight_inputGeneral)
        val heightEditText = findViewById<EditText>(R.id.height_inputGeneral)

        // Set up the profile photo upload button
        findViewById<Button>(R.id.upload_photo_btn).setOnClickListener {
            openGallery()
        }



        findViewById<Button>(R.id.onBackToLogin).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Sign-up button functionality
        findViewById<Button>(R.id.signup_btn).setOnClickListener {
            val dbHelper = DataBaseHelper(this)

            //save user sign in info
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val user:User = RegistrationController().registerUserInfo(username,password,dbHelper)

            //save user
            user.name = nameEditText.text.toString()
            user.role = ROLES.GENERAL
            user.age = ageEditText.text.toString().toIntOrNull() ?: 0
            user.weight = weightEditText.text.toString().toIntOrNull() ?: 0
            user.height = heightEditText.text.toString().toIntOrNull() ?: 0
            RegistrationController().registerUser(user, dbHelper)
        }
    }


private fun openGallery() {
    val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
    startActivityForResult(intent, PICK_IMAGE)
}

override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
        val imageUri: Uri? = data.data
        profilePhoto.setImageURI(imageUri)
    }
}
}
