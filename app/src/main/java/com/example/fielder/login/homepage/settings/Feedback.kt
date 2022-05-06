package com.example.fielder.login.homepage.settings

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fielder.R
import com.example.fielder.login.models.DataStorage
import com.example.fielder.login.models.FeedbackModel
import com.example.fielder.login.services.RetrofitClient
import kotlinx.android.synthetic.main.fragment_feedback.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Feedback : Fragment(R.layout.fragment_feedback) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val message: String = et_feedback.text.toString()


        submit.setOnClickListener {
            RetrofitClient.instance.sendFeedback(message, DataStorage.fname).enqueue(object :
                Callback<FeedbackModel> {
                override fun onResponse(call: Call<FeedbackModel>, response: Response<FeedbackModel>) {
                    Toast.makeText(context, "Feedback Sent Successfully", Toast.LENGTH_SHORT).show()

                }

                override fun onFailure(call: Call<FeedbackModel>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                }

            })


        }

        RetrofitClient.instance.sendFeedback(message, DataStorage.fname).enqueue(object :
            Callback<FeedbackModel> {
            override fun onResponse(call: Call<FeedbackModel>, response: Response<FeedbackModel>) {

            }

            override fun onFailure(call: Call<FeedbackModel>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}