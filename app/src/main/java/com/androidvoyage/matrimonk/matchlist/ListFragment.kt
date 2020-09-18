package com.androidvoyage.matrimonk.matchlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.androidvoyage.matrimonk.R
import com.androidvoyage.matrimonk.comclass.ComUtils
import com.androidvoyage.matrimonk.database.MatchItem
import com.androidvoyage.matrimonk.database.MatchesItemDatabase
import com.androidvoyage.matrimonk.database.StatusMatch
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
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = MatchListAdapter(MatchListAdapter.MatchClickListener(
            { matchAccepted: MatchItem ->
                viewModel.onProfileStatusUpdate(matchAccepted, StatusMatch.ACCEPT.status)
            },
            { matchDeclined: MatchItem ->
                viewModel.onProfileStatusUpdate(matchDeclined, StatusMatch.DECLINE.status)
            }
        ))
        binding.rcvMatches.adapter = adapter

        binding.swipeNewMatches.setOnRefreshListener {
            if(ComUtils().isOnline(requireActivity())){
                viewModel.getNewMatchesList()
            }else{
                viewModel.setNoInternet()
                binding.swipeNewMatches.isRefreshing = false
            }
        }

        viewModel.isRefreshing.observe(viewLifecycleOwner, Observer {
            if (!it) {
                binding.swipeNewMatches.isRefreshing = false
            }
        })

        viewModel.errorMsg.observe(viewLifecycleOwner, Observer {
            ComUtils().showToast(requireActivity(),it)
        })

        return binding.root
    }
}