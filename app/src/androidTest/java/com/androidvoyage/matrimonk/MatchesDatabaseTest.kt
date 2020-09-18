package com.androidvoyage.matrimonk

import android.util.Log
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.androidvoyage.matrimonk.database.MatchItem
import com.androidvoyage.matrimonk.database.MatchesDao
import com.androidvoyage.matrimonk.database.MatchesItemDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class MatchesDatabaseTest{

    private lateinit var placeDao: MatchesDao
    private lateinit var db: MatchesItemDatabase

    @Before
fun createDB(){
    val context = InstrumentationRegistry.getInstrumentation().targetContext

    db = Room.inMemoryDatabaseBuilder(context, MatchesItemDatabase::class.java)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        placeDao = db.matchDatabaseDao
}

    @After
    @Throws(IOException::class)
    fun closeDB(){
        db.close()
    }

    @Test
    @Throws(IOException::class)
    fun insertAndGetPlace(){
        val place = MatchItem()
        placeDao.add(place)
        placeDao.add(place)
        placeDao.add(place)

        val places = placeDao.getList()
        Log.d("TEEST", "insertAndGetPlace: " + places)

    }

}