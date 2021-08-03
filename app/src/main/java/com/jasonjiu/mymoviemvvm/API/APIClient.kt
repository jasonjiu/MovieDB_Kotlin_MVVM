package com.jasonjiu.mymoviemvvm.API

import com.jasonjiu.mymoviemvvm.models.MovieResult
import com.jasonjiu.mymoviemvvm.Utils.Constant
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    private val api = Retrofit.Builder()
        .baseUrl(Constant.BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(getOkhttpClient())
        .build()
        .create(APIServices::class.java)

    fun getPopularMovies(): Single<MovieResult> {
        return api.getPopularMovies()
    }

    private fun getOkhttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.addInterceptor(APIInterceptor())
        return client.build()
    }
}