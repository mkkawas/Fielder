package com.example.fielder.login.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.fielder.R
import com.example.fielder.login.models.DataStorage
import com.example.fielder.login.models.Fields
import com.example.fielder.login.services.RetrofitClient
import kotlinx.android.synthetic.main.fragment_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class SearchFragment: Fragment(R.layout.fragment_search) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_search.setOnClickListener {
            val sport = et_sport.text.toString().trim()
            val city = et_city.text.toString().trim()


            try{
                RetrofitClient.instance.search(
                    sport,
                    city
                ).enqueue(object: Callback<List<Fields>> {
                    override fun onResponse(
                        call: Call<List<Fields>>,
                        response: Response<List<Fields>>
                    ) {
                             DataStorage.fields = response.body()!!

                            val action = SearchFragmentDirections.actionSearchFragmentToSearchResultFragment()
                            view.findNavController().navigate(action)




                    }

                    override fun onFailure(call: Call<List<Fields>>, t: Throwable) {

                        Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()

                    }


                })
            }catch(e: Exception){
                Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
            }


        }







    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search,container, false)
    }
}