package com.example.fielder.login.homepage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fielder.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private lateinit var name:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navController = findNavController(R.id.nav_fragment)
        val bottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        bottomNavigationView.setupWithNavController(navController)
        name = intent.getStringExtra("name").toString()

    }

    fun getName(): String{
        return name
    }




}