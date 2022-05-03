package com.example.fielder.login.homepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fielder.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val settings = SettingsFragment()
    private val home = HomeFragment()
    private val search = SearchFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        //Initialize the bottom navigation view
        //create bottom navigation view object
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigatin_view)
        val navController = findNavController(R.id.nav_fragment)
        bottomNavigationView.setupWithNavController(navController)

    }


}