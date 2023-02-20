package com.example.newsapp.Model

import retrofit2.http.GET
import retrofit2.http.Query
import com.example.newsapp.Model.NewsModel
import com.example.newsapp.Model.Result
import retrofit2.Response
import retrofit2.Call

interface RetrofitServices {

    @GET("now_playing")
    suspend fun getNews(@Query("apiKey") key: String): NewsModel

}