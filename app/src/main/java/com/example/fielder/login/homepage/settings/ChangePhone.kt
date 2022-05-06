package com.example.fielder.login.homepage.settings

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fielder.R
import com.example.fielder.login.models.ChangePassModel
import com.example.fielder.login.models.ChangePhoneModel
import com.example.fielder.login.models.DataStorage
import com.example.fielder.login.services.RetrofitClient

import kotlinx.android.synthetic.main.fragment_change_phone.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChangePhone: Fragment(R.layout.fragment_change_phone) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submitPhone.setOnClickListener {

            val oldphone = et_oldPhone.text.toString().trim()
            val newphone = et_newPhone.text.toString().trim()

            if (oldphone.trim().isEmpty()) {
                et_oldPhone.error = "Old Phone Number Required"
                return@setOnClickListener
            }
            if (newphone.isEmpty()) {
                et_newPhone.error = "New Phone Number Required"
                return@setOnClickListener
            }

            if (oldphone == newphone) {
                et_newPhone.error = "New Phone Number Is Identical To Old Phone Number"
                return@setOnClickListener
            }

            RetrofitClient.instance.changePhone(
                DataStorage.email,
                oldphone,
                newphone
            ).enqueue(object:Callback<ChangePassModel> {
                override fun onResponse(
                    call: Call<ChangePassModel>,
                    response: Response<ChangePassModel>
                ) {
                    val error = response.body()!!.error
                    val message = response.body()!!.message

                    if(!error){
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                        val action = ChangePhoneDirections.actionChangePhone2ToSettingsFragment()
                        view.findNavController().navigate(action)
                    }else{
                        et_oldPhone.error = message
                    }

                }

                override fun onFailure(call: Call<ChangePassModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

        }
    }
}