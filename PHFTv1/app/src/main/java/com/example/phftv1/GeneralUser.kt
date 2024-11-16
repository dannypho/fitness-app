package com.example.phftv1

//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat

//class GeneralUser : AppCompatActivity() {
//
//
//
//    private lateinit var usernameInput: EditText
//    private lateinit var passwordInput: EditText
//    private lateinit var loginBtn: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_general_user)
//
//
//
//
//
//        findViewById<Button>(R.id.back_btn).setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//
//
//
//        }
//
//}
//}
//


//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import com.example.Controller.RegistrationController
//
//import java.io.BufferedReader
//import java.io.File
//import java.io.FileInputStream
//import java.io.IOException
//import java.io.InputStreamReader
//
//
//class GeneralUser : AppCompatActivity() {
//
//    private lateinit var usernameInput: EditText
//    private lateinit var passwordInput: EditText
//    private lateinit var loginBtn: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_general_user)
//
//        // Find views by IDs
//        usernameInput = findViewById(R.id.username_input)
//        passwordInput = findViewById(R.id.password_input)
//        loginBtn = findViewById(R.id.login_btn)
//
//        // Back button listener
//        findViewById<Button>(R.id.back_btn).setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//
//        // Login button listener
//        loginBtn.setOnClickListener {
//            val username = usernameInput.text.toString().trim()
//            val password = passwordInput.text.toString().trim()
//            RegistrationController().login(username, password)
//        }
//
//    }
//}
//
//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//
//import com.example.Controller.RegistrationController
//import com.example.backend.DataBaseHelper
//
//import java.io.BufferedReader
//import java.io.File
//import java.io.FileInputStream
//import java.io.IOException
//import java.io.InputStreamReader
//
//
//class GeneralUser : AppCompatActivity() {
//
//    private lateinit var usernameInput: EditText
//    private lateinit var passwordInput: EditText
//    private lateinit var loginBtn: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_general_user)
//
//        // Find views by IDs
//        usernameInput = findViewById(R.id.username_input)
//        passwordInput = findViewById(R.id.password_input)
//        loginBtn = findViewById(R.id.login_btn)
//
//        // Back button listener
//        findViewById<Button>(R.id.back_btn).setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//
//        // Login button listener
//        loginBtn.setOnClickListener {
//            val dbHelper = DataBaseHelper(this)
//            val username = usernameInput.text.toString().trim()
//            val password = passwordInput.text.toString().trim()
//
//
//            // Input validation
//            if (username.isEmpty() || password.isEmpty()) {
//                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            // Check credentials
//            if (checkCredentials(username, password)) {
//                Log.i("USER CHECK", "Login successful")
//                // Navigate to the next activity
//                val intent = Intent(this, Dashboard::class.java)
//                startActivity(intent)
//            } else {
//                Log.i("USER CHECK", "Login unsuccessful")
//                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
//            }
//
//            Log.i("TEST Credentials", "Username: $username and Password: $password")
//           val isLoggedIn = RegistrationController().login(username, password, dbHelper)
//
//            if (!isLoggedIn){
//                // print to user that the password or username is incorrect
//            }
//
//        }
//    }
//
//    private fun checkCredentials(username: String, password: String): Boolean {
//        // Hardcoded credentials for testing
//        val credentials = mapOf(
//            "user1" to "password1",
//            "user2" to "password2",
//            "u" to "p",
//            "user3" to "password3"
//        )
//        return credentials[username] == password
//    }
//}


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Controller.RegistrationController
import com.example.backend.DataBaseHelper
import com.example.Model.User

var userid = "0"

class GeneralUser : AppCompatActivity() {

    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginBtn: Button
    private lateinit var registerBtn: Button // Button for registration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_general_user)

        // Find views by IDs
        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginBtn = findViewById(R.id.login_btn)

        // Back button listener
        findViewById<Button>(R.id.back_btn).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Login button listener
        loginBtn.setOnClickListener {
            val dbHelper = DataBaseHelper(this)
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check credentials in the database
            if (dbHelper.verifyLogin(username, password)) {
                Log.i("USER CHECK", "Login successful")
                userid = dbHelper.getUID(username)
                val intent = Intent(this, Dashboard::class.java)
                startActivity(intent)
            } else {
                Log.i("USER CHECK", "Login unsuccessful")
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
