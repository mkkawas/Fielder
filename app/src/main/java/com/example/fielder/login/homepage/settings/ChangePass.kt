package com.example.fielder.login.homepage.settings

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fielder.R
import com.example.fielder.login.models.ChangePassModel
import com.example.fielder.login.models.DataStorage
import com.example.fielder.login.services.RetrofitClient
import kotlinx.android.synthetic.main.fragment_change_pass.*
import kotlinx.android.synthetic.main.fragment_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChangePass : Fragment(R.layout.fragment_change_pass) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submitPass.setOnClickListener {

            val oldpass = et_oldPass.text.toString().trim()
            val newpass = et_newPass.text.toString().trim()

            if (oldpass.trim().isEmpty()) {
                et_oldPass.error = "Old Password Required"
                return@setOnClickListener
            }
            if (newpass.isEmpty()) {
                et_newPass.error = "Old Password Required"
                return@setOnClickListener
            }

            if (oldpass == newpass) {
                et_newPass.error = "New Password Is Identical To Old Password"
                return@setOnClickListener
            }

            RetrofitClient.instance.changePass(
                DataStorage.email,
                oldpass,
                newpass
            ).enqueue(object : Callback<ChangePassModel>{
                override fun onResponse(
                    call: Call<ChangePassModel>,
                    response: Response<ChangePassModel>
                ) {
                    val error = response.body()!!.error
                    val message = response.body()!!.message

                    if(!error){
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                        val action = ChangePassDirections.actionChangePass2ToSettingsFragment()
                        view.findNavController().navigate(action)
                    }else{
                        et_oldPass.error = message
                    }

                }

                override fun onFailure(call: Call<ChangePassModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

        }

    }
}