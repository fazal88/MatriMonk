package com.androidvoyage.matrimonk

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.androidvoyage.matrimonk.databinding.FragmentListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListFragment : Fragment() {

    private lateinit var binding : FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_list,container,false)

        getListMatches()

        return binding.root
    }

    private fun getListMatches() {
        MatchesApi.retrofitService.getListMatches(10).enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                binding.tvResult.text = response.body()
                Log.d("API", "onResponse: "+response.body())
                Toast.makeText(context, response.message(), Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("API", "onResponse: "+t.localizedMessage)
                Toast.makeText(context, "Failed!", Toast.LENGTH_LONG).show()
            }

        })
    }
}