//package com.example.phftv1
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import com.example.Controller.RegistrationController
//
//class UserPersonalInformation : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_user_personal_information)
////        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
////            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
////            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
////            insets
////        }
//        val ageEditText = findViewById<EditText>(R.id.age_inputGeneral)
//        val weightEditText = findViewById<EditText>(R.id.weight_inputGeneral)
//        val heightEditText = findViewById<EditText>(R.id.height_inputGeneral)
//
//        findViewById<Button>(R.id.signup_btnGeneral).setOnClickListener {
//            val age = ageEditText.text.toString().toInt()
//            val weight = weightEditText.text.toString().toInt()
//            val height = heightEditText.text.toString().toInt()
//            RegistrationController().setProfile(age,weight,height)
//        }
//
//
//
//        findViewById<Button>(R.id.back_btnGeneral).setOnClickListener {
//            val intent = Intent(this, SignUp::class.java)
//            startActivity(intent)
//        }
//    }
//}

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
import com.example.backend.DataBaseHelper

class UserPersonalInformation : AppCompatActivity() {
    private lateinit var profilePhoto: ImageView
    private val PICK_IMAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_personal_information)

        profilePhoto = findViewById(R.id.profile_photo)
        val ageEditText = findViewById<EditText>(R.id.age_inputGeneral)
        val weightEditText = findViewById<EditText>(R.id.weight_inputGeneral)
        val heightEditText = findViewById<EditText>(R.id.height_inputGeneral)


        // Set up the profile photo upload button
        findViewById<Button>(R.id.upload_photo_btn).setOnClickListener {
            openGallery()

        findViewById<Button>(R.id.signup_btnGeneral).setOnClickListener {
            val dbHelper = DataBaseHelper(this)
            val age = ageEditText.text.toString().toInt()
            val weight = weightEditText.text.toString().toInt()
            val height = heightEditText.text.toString().toInt()
            RegistrationController().setProfile(age,weight,height,dbHelper)
        }

        // Sign-up button functionality
        findViewById<Button>(R.id.signup_btnGeneral).setOnClickListener {
            val age = ageEditText.text.toString().toIntOrNull() ?: 0
            val weight = weightEditText.text.toString().toIntOrNull() ?: 0
            val height = heightEditText.text.toString().toIntOrNull() ?: 0
            RegistrationController().setProfile(age, weight, height)
        }

        // Back button functionality
        findViewById<Button>(R.id.back_btnGeneral).setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
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
