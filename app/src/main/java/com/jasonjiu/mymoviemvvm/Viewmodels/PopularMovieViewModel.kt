package com.jasonjiu.mymoviemvvm.Viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jasonjiu.mymoviemvvm.API.APIClient
import com.jasonjiu.mymoviemvvm.models.Movie
import com.jasonjiu.mymoviemvvm.models.MovieResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PopularMovieViewModel(application: Application) : AndroidViewModel(application) {
    private val api = APIClient()
    private val dispos = CompositeDisposable()

    val popularMovie = MutableLiveData<List<Movie>>()
    val loading = MutableLiveData<Boolean>()

    fun getPopularMovies(){
        loading.value = true
        dispos.add(
            api.getPopularMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<MovieResult>() {
                    override fun onSuccess(t: MovieResult) {
                        popularMovie.value = t.results
                        loading.value = false
                        Log.d("asd1 ", "berhasil")
                        Log.d("asd2", "onSuccess: "+ t.results)
                    }

                    override fun onError(e: Throwable) {
                        Log.d("asd3", "error: " + e.message)
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        dispos.clear()
    }

}