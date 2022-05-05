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
import com.example.fielder.login.models.DataStorage
import com.example.fielder.login.models.Fields
import com.example.fielder.login.services.RetrofitClient
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchResultFragment: Fragment(R.layout.fragment_search_result) {

    private lateinit var searchAdapter: SearchAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initRecyclerView(DataStorage.fields)


    }

    private fun initRecyclerView(fields: List<Fields>) {

        rv_suggestions.apply {
            layoutManager = LinearLayoutManager(context)
            searchAdapter = SearchAdapter(fields)
            adapter = searchAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        //val activity = HomeActivity()
        //tv_welcome.text = "Welcome "+ activity.getName()
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }




}