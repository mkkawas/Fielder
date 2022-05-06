package com.example.fielder.login.homepage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fielder.R
import com.example.fielder.login.main.MainActivity
import com.example.fielder.login.models.DataStorage
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment: Fragment(R.layout.fragment_settings){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        feedback.setOnClickListener {
            val action = SettingsFragmentDirections.actionSettingsFragmentToFeedback2()
            view.findNavController().navigate(action)

        }

        changePass.setOnClickListener {

        }

        changePhone.setOnClickListener {

        }

        LogOut.setOnClickListener {

            DataStorage.reset()
            val i =  Intent(context, MainActivity::class.java)
            startActivity(i)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings,container, false)
    }
}