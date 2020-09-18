package com.androidvoyage.matrimonk.matchlist

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    private val _errorMsg = MutableLiveData<String>("Swipe down to load new matches")
    val errorMsg: LiveData<String>
        get() = _errorMsg

    private val _isRefreshing = MutableLiveData<Boolean>(false)
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getNewMatchesList() {
        uiScope.launch {
            _isRefreshing.value = true
            val getMatchesDeferred = MatchesApi.retrofitService.getListMatches(10)
            try {
                val listResults = getMatchesDeferred.await().results
                if (listResults.size > 0) {
                    saveList(listResults)
                    _errorMsg.value = "Swipe down for new matches"
                } else {
                    _errorMsg.value = "No New Data !"
                }
                _isRefreshing.value = false
            } catch (t: Throwable) {
                _errorMsg.value = "Oops! Please try again."
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

    fun onProfileStatusUpdate(item: MatchItem, action: Int) {
        uiScope.launch {
            updateStatus(item, action)
        }
    }

    private suspend fun updateStatus(it: MatchItem, action: Int) {
        return withContext(Dispatchers.IO) {
            val item = database.get(it.matchId)
            /*item.isProfileActive = item.isProfileActive.not()*//*todo update status here*/
            database.update(item!!)
            return@withContext
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun setNoIternet() {
        _errorMsg.value = "No Internet!"
    }

}