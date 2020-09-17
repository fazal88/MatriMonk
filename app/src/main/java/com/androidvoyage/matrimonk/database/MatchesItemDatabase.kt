package com.androidvoyage.matrimonk.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MatchItem::class], version = 1, exportSchema = false)
abstract class MatchesItemDatabase : RoomDatabase() {

    abstract val matchDatabaseDao: MatchesDao

    companion object {

        @Volatile
        private var INSTANCE: MatchesItemDatabase? = null

        fun getInstance(context: Context): MatchesItemDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            MatchesItemDatabase::class.java,
                            "matches_database"
                    )
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}