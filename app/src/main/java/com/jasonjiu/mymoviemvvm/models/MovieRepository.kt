package com.jasonjiu.mymoviemvvm.models

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.jasonjiu.mymoviemvvm.localdb.MovieDao
import com.jasonjiu.mymoviemvvm.localdb.Moviedb

class MovieRepository(context: Context) {

    private val db: Moviedb by lazy {
        Moviedb.getInstance(context)
    }
    private val dao: MovieDao by lazy {
        db.movieDao()
    }

    private class InsertAsyncTask(val dao: MovieDao): AsyncTask<Movie, Void, Void>(){
        override fun doInBackground(vararg params: Movie?): Void? {
            dao.insertMovie(params[0])
            return null
        }
    }

    private class DeleteAsyncTask(val dao: MovieDao): AsyncTask<Movie, Void, Void>(){
        override fun doInBackground(vararg params: Movie?): Void? {
            dao.deleteMovie(params[0])
            return null
        }
    }

    fun insertMovie(movieResult: Movie?){
        InsertAsyncTask(
            dao
        ).execute(movieResult)
    }

    fun deleteMovie(movieResult: Movie?){
        DeleteAsyncTask(
            dao
        ).execute(movieResult)
    }

    fun getAllMovies(): LiveData<List<Movie>> {
        return dao.getAllMovies()
    }

    fun getSingleMovie(movieId:Int?): LiveData<Movie> {
        return dao.getSingleMovie(movieId!!)
    }

}