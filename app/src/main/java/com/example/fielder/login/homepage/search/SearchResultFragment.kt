package com.example.fielder.login.homepage.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fielder.R
import com.example.fielder.login.models.DataStorage
import com.example.fielder.login.models.Fields
import kotlinx.android.synthetic.main.fragment_search_result.*

class SearchResultFragment: Fragment(R.layout.fragment_search_result) {

    private lateinit var searchAdapter: SearchAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initRecyclerView(DataStorage.fields)


    }

    private fun initRecyclerView(fields: List<Fields>) {

        searchRecycler.apply {
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