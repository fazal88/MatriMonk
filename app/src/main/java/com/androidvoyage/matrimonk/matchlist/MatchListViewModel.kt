package com.androidvoyage.matrimonk.matchlist

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidvoyage.matrimonk.R
import com.androidvoyage.matrimonk.comclass.MatchesApi
import com.androidvoyage.matrimonk.database.MatchItem
import com.androidvoyage.matrimonk.database.MatchesDao
import kotlinx.coroutines.*

class MatchListViewModel(
    private val database: MatchesDao,
    private val application: Application
) : ViewModel() {

    private val _matchList = database.getAll()

    val matchList: LiveData<List<MatchItem>>
        get() = _matchList

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String>
        get() = _errorMsg

    private val _isRefreshing = MutableLiveData(false)
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getNewMatchesList() {
        uiScope.launch {
            _isRefreshing.value = true
            val getMatchesDeferred = MatchesApi.retrofitService.getListMatchesAsync(10)
            try {
                val listResults = getMatchesDeferred.await().results
                if (listResults.isNotEmpty()) {
                    saveList(listResults)
                    _errorMsg.value = application.getString(R.string.str_new_matches)
                } else {
                    _errorMsg.value = application.getString(R.string.str_no_new_data)
                }
                _isRefreshing.value = false
            } catch (t: Throwable) {
                _errorMsg.value = application.getString(R.string.str_error_api)
                _isRefreshing.value = false
            }
        }
    }

    private suspend fun saveList(listResults: List<MatchItem>) {
        return withContext(Dispatchers.IO) {
            database.saveAll(listResults)
            return@withContext
        }
    }

    fun onProfileStatusUpdate(item: MatchItem, action: String) {
        uiScope.launch {
            updateStatus(item, action)
        }
    }

    private suspend fun updateStatus(it: MatchItem, action: String) {
        return withContext(Dispatchers.IO) {
            val item = database.get(it.matchId)
            item?.status = action
            database.update(item!!)
            return@withContext
        }
    }

    fun clearAll() {
        uiScope.launch {
            deleteAll()
        }
    }

    private suspend fun deleteAll() {
        return withContext(Dispatchers.IO) {
            database.deleteAll()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun setNoInternet() {
        _errorMsg.value = application.getString(R.string.str_no_internet)
    }

}