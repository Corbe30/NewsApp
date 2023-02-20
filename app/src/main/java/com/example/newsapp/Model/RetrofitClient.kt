package com.example.newsapp.Model

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

public class RetrofitClient {

    public fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/everything")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}