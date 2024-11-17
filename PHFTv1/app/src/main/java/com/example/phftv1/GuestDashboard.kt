package com.example.phftv1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.View.DashBoardFragment
import com.example.View.MonitoringFragment
import com.example.View.ProfileFragment
import com.example.backend.SessionManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class GuestDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.new_dashboard)

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

