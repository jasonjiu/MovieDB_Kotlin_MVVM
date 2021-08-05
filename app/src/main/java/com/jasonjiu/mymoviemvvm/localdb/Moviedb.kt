package com.jasonjiu.mymoviemvvm.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jasonjiu.mymoviemvvm.models.Movie

@Database(entities = [Movie::class], version = 1)
abstract class Moviedb: RoomDatabase(){

    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        var instance: Moviedb? = null

        @Synchronized
        fun getInstance(context: Context): Moviedb {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    Moviedb::class.java,
                    "movies.db"
                ).build()
            }
            return instance as Moviedb
        }
    }
}