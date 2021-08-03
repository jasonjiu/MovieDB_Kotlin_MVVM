package com.jasonjiu.mymoviemvvm.API

import com.jasonjiu.mymoviemvvm.models.MovieResult
import io.reactivex.Single
import retrofit2.http.GET

interface APIServices {
    @GET("movie/popular")
    fun getPopularMovies(): Single<MovieResult>
}