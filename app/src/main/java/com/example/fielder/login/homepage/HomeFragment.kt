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
import com.example.fielder.login.models.Field

import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var suggestionAdapter: SuggestionAdapter

    private fun addDataSet(){
        val data = mockSource.createDataSet()
        suggestionAdapter.submitList(data)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_welcome.text = "Welcome "+DataStorage.fname


        initRecyclerView()
        addDataSet()

    }

    private fun initRecyclerView(){

        rv_suggestions.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

            suggestionAdapter = SuggestionAdapter()
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
        return inflater.inflate(R.layout.fragment_home,container, false)
    }


}