package com.example.fielder.login.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fielder.R
import com.example.fielder.login.homepage.HomeActivity
import com.example.fielder.login.models.LogInModel
import com.example.fielder.login.services.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class LogInFragment: Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            val email = et_login_email.text.toString().trim()
            val pass = et_login_pass.text.toString().trim()

            if(email.isEmpty()){
                et_login_email.error = "email required"
                return@setOnClickListener
            }
            if(email.isEmpty()){
                et_login_pass.error = "password required"
                return@setOnClickListener
            }

            try{
                RetrofitClient.instance.logIn(
                    email,
                    pass
                ).enqueue(object: Callback<LogInModel>{
                    override fun onResponse(
                        call: Call<LogInModel>,
                        response: Response<LogInModel>
                    ) {
                        val error = response.body()?.error
                        val message = response.body()?.message
                        if(error==false){
                            val intent= Intent(context, HomeActivity::class.java)
                            startActivity(intent)
                        }else{

                            when(message){
                                "password doesn't match email"-> et_login_pass.error= "password mismatches email"
                                "email not registered"-> et_login_email.error = "email not registered"
                            }

                        }

                        //Toast.makeText(context, response.body()?.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onFailure(call: Call<LogInModel>, t: Throwable) {
                        Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
                    }

                })
            }catch(e: Exception){
                Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
            }



        }
        register.setOnClickListener{
            val action = LogInFragmentDirections.actionLogInFragment2ToRegisterFragment2()
            view.findNavController().navigate(action)
        }
    }
}