package com.example.fielder.login.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fielder.R
import com.example.fielder.login.homepage.HomeActivity

import com.example.fielder.login.models.RegisterModel
import com.example.fielder.login.services.RetrofitClient

import kotlinx.android.synthetic.main.fragment_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class RegisterFragment: Fragment(R.layout.fragment_register) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_create.setOnClickListener {

            val fname = et_fname.text.toString().trim()
            val sname = et_sname.text.toString().trim()
            val email = et_email.text.toString().trim()
            val rep_email = et_rep_email.text.toString().trim()
            val pass = et_password.text.toString().trim()
            val rep_pass = et_rep_password.text.toString().trim()
            val phonenb = et_phone.text.toString().trim()



            if (fname.isEmpty()){
                et_fname.error = "First Name Required"
                return@setOnClickListener
            }
            if (sname.isEmpty()){
                et_sname.error = "Surname Required"
                return@setOnClickListener
            }
            if (email.isEmpty()){
                et_email.error = "email Required"
                return@setOnClickListener
            }
            if (rep_email.isEmpty() || rep_email!=email){
                et_rep_email.error = "email does not match"
                return@setOnClickListener
            }
            if (pass.isEmpty()){
                et_password.error = "Password Required"
                return@setOnClickListener
            }
            if (rep_pass.isEmpty() || rep_pass!=pass){
                et_rep_password.error = "password does not match"
                return@setOnClickListener
            }

            try{
            RetrofitClient.instance.createUser(
                fname,
                sname,
                email,
                pass,
                phonenb
            ).enqueue(object: Callback<RegisterModel>{
                override fun onResponse(
                    call: Call<RegisterModel>,
                    response: Response<RegisterModel>
                ) {
                    val error = response.body()?.error
                  // Toast.makeText(context, response.body()?.message,Toast.LENGTH_SHORT).show()
                    if(error == false){
                        val intent = Intent(context, HomeActivity::class.java)
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
                }

            })


        }catch (e: Exception){
            Toast.makeText(context,e.message,Toast.LENGTH_LONG).show()

            }
        }


    }



    }
