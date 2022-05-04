package com.example.fielder.login.homepage


import android.content.pm.PackageManager
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fielder.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.fielder.login.models.DataStorage
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


class HomeActivity : AppCompatActivity() {

    //lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    private lateinit var name:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

     //   fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

      //  fetchLocation()



        val navController = findNavController(R.id.nav_fragment)
        val bottomNavigationView =
            findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        bottomNavigationView.setupWithNavController(navController)
        name = intent.getStringExtra("name").toString()

    }
//
//    private fun fetchLocation() {
//        val task = fusedLocationProviderClient.lastLocation
//        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
//            != PackageManager.PERMISSION_GRANTED
//            && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
//            != PackageManager.PERMISSION_GRANTED )
//            {
//
//            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101)
//            return
//        }
//        task.addOnSuccessListener {
//            if(it!=null){
//                //Toast.makeText(applicationContext, "${it.latitude} ${it.longitude}", Toast.LENGTH_SHORT).show()
//                DataStorage.city = "lat: ${it.latitude} and long: ${it.longitude}"
//            }
//        }
//
//
//    }

    fun getName(): String{
        return name
    }




}



