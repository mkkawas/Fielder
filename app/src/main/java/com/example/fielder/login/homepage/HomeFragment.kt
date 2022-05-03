package com.example.fielder.login.homepage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fielder.R
import com.example.fielder.login.main.LogInFragmentDirections
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textview.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
            view.findNavController().navigate(action)
        }

    }
}