package com.example.fielder.login.homepage


import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fielder.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle




class HomeActivity : AppCompatActivity() {

    private lateinit var name:String




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()



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



