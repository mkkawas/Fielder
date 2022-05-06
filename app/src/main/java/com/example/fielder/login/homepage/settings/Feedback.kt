package com.example.fielder.login.homepage.settings

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
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




        submit.setOnClickListener {
            val message = et_feedback.text

            RetrofitClient.instance.sendFeedback(message, DataStorage.email).enqueue(object :
                Callback<FeedbackModel> {
                override fun onResponse(call: Call<FeedbackModel>, response: Response<FeedbackModel>) {
                    Toast.makeText(context, "Feedback Sent Successfully", Toast.LENGTH_SHORT).show()
                    val action = FeedbackDirections.actionFeedback2ToSettingsFragment()
                    view.findNavController().navigate(action)

                }

                override fun onFailure(call: Call<FeedbackModel>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                }

            })


        }

    }
}