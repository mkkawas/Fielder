package com.example.fielder.login.homepage

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fielder.R
import com.example.fielder.login.main.LogInFragmentDirections
import com.example.fielder.login.models.DataStorage
import com.example.fielder.login.models.Field
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment(R.layout.fragment_home) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_welcome.text = "Welcome "+DataStorage.fname

        val items: ArrayList<Field>

        rv_suggestions.layoutManager = LinearLayoutManager(context)
        rv_suggestions.adapter = SuggestionAdapter()


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        //val activity = HomeActivity()
        //tv_welcome.text = "Welcome "+ activity.getName()
        return inflater.inflate(R.layout.fragment_home,container, false)
    }


}