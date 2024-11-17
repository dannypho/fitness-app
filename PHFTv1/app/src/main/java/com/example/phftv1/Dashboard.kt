package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.Model.ROLES
import com.example.View.DashBoardFragment
import com.example.View.MonitoringFragment
import com.example.View.ProfileFragment
import com.example.backend.DataBaseHelper
import com.example.backend.SessionManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.new_dashboard)

        if (SessionManager.currentUser.role == ROLES.GUEST){
            val intent = Intent(this, GuestDashboard::class.java)
            startActivity(intent)
        }
        if (SessionManager.currentUser.role == ROLES.TRAINER){
            val intent = Intent(this, PersonalTrainerDashboard::class.java)
            startActivity(intent)
        }


        val navView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val dashBoardFragment = DashBoardFragment()
        val monitoringFragment = MonitoringFragment()
        val profileFragment = ProfileFragment()

         setFragment(dashBoardFragment)



        navView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.dashboard -> {setFragment(dashBoardFragment) }
                R.id.monitoring -> {setFragment(monitoringFragment)}
                R.id.profile -> {setFragment(profileFragment)}
            }
            true
        }

    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }

    }



    }
