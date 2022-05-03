package com.example.fielder.login.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fielder.R
import com.example.fielder.login.main.LogInFragmentDirections
import com.example.fielder.login.models.DataStorage
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_welcome.text = "Welcome "+DataStorage.fname+" "+DataStorage.sname


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