package com.androidvoyage.matrimonk.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MatchesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(match : MatchItem)

    @Update
    fun update(match : MatchItem)

    @Query("SELECT * FROM matches_entry_table WHERE matchId = :id")
    fun get(id : Long): MatchItem?

    @Query("SELECT * FROM matches_entry_table ORDER BY matchId DESC LIMIT 1")
    fun getLast(): MatchItem?

    @Query("SELECT * FROM matches_entry_table ORDER BY matchId DESC")
    fun getAll(): LiveData<List<MatchItem>>

    @Query("SELECT * FROM matches_entry_table ORDER BY matchId DESC")
    fun getList(): List<MatchItem>

    @Delete
    fun delete(match : MatchItem)

    @Query("DELETE FROM matches_entry_table WHERE matchId = :id")
    fun delete(id : Long)

    @Query("DELETE FROM matches_entry_table")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(listResults: List<MatchItem>)

}