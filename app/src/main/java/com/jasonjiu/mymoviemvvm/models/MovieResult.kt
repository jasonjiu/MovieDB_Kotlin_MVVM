package com.jasonjiu.mymoviemvvm.models

import com.google.gson.annotations.SerializedName

data class MovieResult (
    @SerializedName("results")
    var results: List<Movie>
)