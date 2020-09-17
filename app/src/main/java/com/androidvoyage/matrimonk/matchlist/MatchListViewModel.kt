package com.androidvoyage.matrimonk.matchlist

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidvoyage.matrimonk.database.MatchItem
import com.androidvoyage.matrimonk.database.MatchesDao
import com.androidvoyage.matrimonk.database.ResponseResults
import com.androidvoyage.matrimonk.matchlist.MatchesApi
import com.androidvoyage.matrimonk.matchlist.MatchesApiService
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchListViewModel(
        private val database: MatchesDao,
        private val application: Application) : ViewModel() {

    val matchList = database.getAll()

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        getListMatches()
    }

    private fun getListMatches() {
        uiScope.launch {
            var getMatchesDeferred = MatchesApi.retrofitService.getListMatches(10)
            try {
                var listResult = getMatchesDeferred.await().results
                Log.d("API", "onResponse: "+listResult.size)
            } catch (t: Throwable) {
                Log.d("API", "onFail: "+t.localizedMessage)
            }
        }
    }

    /*private val _navigateToProfileEdit = MutableLiveData<MatchItem>()
    val navigateToProfileEdit
        get() = _navigateToProfileEdit

    fun onProfileClickToNavigate(profile: MatchItem) {
        _navigateToProfileEdit.value = profile
    }

    fun onProfileEditNavigated() {
        _navigateToProfileEdit.value = null
    }

    fun onProfileClickToDelete(it: Long) {
        uiScope.launch {
            deleteProfile(it)
        }
    }

    private suspend fun deleteProfile(it: Long) {
        return withContext(Dispatchers.IO) {
            return@withContext database.delete(it)
        }
    }*/

    fun onProfileStatusUpdate(id: Long, action: String) {
        uiScope.launch {
            updateStatus(id, action)
        }
    }

    private suspend fun updateStatus(it: Long, action: String) {
        return withContext(Dispatchers.IO) {
            val item = database.get(it)!!
            /*item.isProfileActive = item.isProfileActive.not()*/
            database.update(item)
            return@withContext
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}