package com.jasonjiu.mymoviemvvm.API

import com.jasonjiu.mymoviemvvm.Utils.Constant
import okhttp3.Interceptor
import okhttp3.Response

class APIInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url()
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", Constant.APIKEY)
            .build()
        val request = originalRequest.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}