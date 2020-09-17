package com.androidvoyage.matrimonk.matchlist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidvoyage.matrimonk.database.MatchesDao

class MatchListViewModelFactory (
    private val dataSource: MatchesDao,
    private val application: Application) : ViewModelProvider.Factory
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MatchListViewModel::class.java)){
            return MatchListViewModel(dataSource,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}
