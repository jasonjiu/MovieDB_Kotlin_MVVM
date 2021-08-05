package com.jasonjiu.mymoviemvvm.Viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.jasonjiu.mymoviemvvm.models.Movie
import com.jasonjiu.mymoviemvvm.models.MovieRepository

class FavoriteMovieViewModel(application: Application): AndroidViewModel(application) {

    private val repository: MovieRepository by lazy {
        MovieRepository(
            application.applicationContext
        )
    }

    fun insertMovie(movie: Movie?) = repository.insertMovie(movie)
    fun deleteMovie(movie: Movie?) = repository.deleteMovie(movie)
    fun getAllMovies(): LiveData<List<Movie>> = repository.getAllMovies()
    fun getSingleMovie(movieId:Int?) : LiveData<Movie> = repository.getSingleMovie(movieId)


}