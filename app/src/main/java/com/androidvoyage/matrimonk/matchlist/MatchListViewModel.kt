package com.androidvoyage.matrimonk.matchlist

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidvoyage.matrimonk.database.MatchItem
import com.androidvoyage.matrimonk.database.MatchesDao
import kotlinx.coroutines.*

class MatchListViewModel(
        private val database: MatchesDao,
        private val application: Application) : ViewModel() {

    private val _matchList = MutableLiveData<List<MatchItem>>()

    val matchList : LiveData<List<MatchItem>>
    get() = _matchList

    private val _errorMsg = MutableLiveData<String>("Loading...")

    val errorMsg : LiveData<String>
        get() = _errorMsg

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        getListMatches()
    }

    private fun getListMatches() {
        uiScope.launch {
            var getMatchesDeferred = MatchesApi.retrofitService.getListMatches(10)
            try {
                val listResults = getMatchesDeferred.await().results
                Log.d("API", "onResponse: "+listResults.size)
                if(listResults.size>0){
                    _matchList.value = listResults
                    _errorMsg.value = ""
                }else{
                    _errorMsg.value = "No Data Available !"
                }
            } catch (t: Throwable) {
                Log.d("API", "onFail: "+t.localizedMessage)
                _errorMsg.value = t.localizedMessage
            }
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

}