package com.example.fielder.login.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fielder.R
import com.example.fielder.login.homepage.search.SuggestionAdapter
import com.example.fielder.login.models.DataStorage
import com.example.fielder.login.models.Fields
import com.example.fielder.login.services.RetrofitClient

import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var suggestionAdapter: SuggestionAdapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_welcome.text = "Welcome " + DataStorage.fname




        RetrofitClient.instance.getFields().enqueue( object: Callback<List<Fields>>{
            override fun onResponse(call: Call<List<Fields>>, response: Response<List<Fields>>) {
                initRecyclerView(response.body()!!)
               // Toast.makeText(context, "success", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<List<Fields>>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }

        }
        )


    }

    private fun initRecyclerView(fields: List<Fields>) {

        rv_suggestions.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            suggestionAdapter = SuggestionAdapter(fields)
            adapter = suggestionAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        //val activity = HomeActivity()
        //tv_welcome.text = "Welcome "+ activity.getName()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }




}







