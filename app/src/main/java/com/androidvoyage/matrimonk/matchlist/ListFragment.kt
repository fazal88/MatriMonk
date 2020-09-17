package com.androidvoyage.matrimonk.matchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.androidvoyage.matrimonk.R
import com.androidvoyage.matrimonk.database.MatchesItemDatabase
import com.androidvoyage.matrimonk.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: MatchListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)

        val application = requireNotNull(this.activity).application
        val database = MatchesItemDatabase.getInstance(application).matchDatabaseDao
        val matchListViewModelFactory = MatchListViewModelFactory(database, application)
        viewModel = ViewModelProvider(this, matchListViewModelFactory).get(MatchListViewModel::class.java)
        /*viewModel = ViewModelProviders.of(this).get(MatchListViewModel::class.java)*/
        binding.lifecycleOwner = this

        return binding.root
    }
}