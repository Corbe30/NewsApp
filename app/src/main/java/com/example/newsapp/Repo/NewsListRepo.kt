package com.example.newsapp.Repo

import com.example.newsapp.Model.NewsModel
import com.example.newsapp.Model.RetrofitClient
import com.example.newsapp.Model.RetrofitServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class NewsListRepo {
    suspend fun fetchMovieData() : NewsModel? {
        val retrofit = RetrofitClient().getInstance()
        val request = retrofit.create(RetrofitServices::class.java)

        println("outside call")
        return withContext(Dispatchers.IO) {
            val async = async {
                request.getNews("07846cb6a92742d0a359eeb8782e8fa0")
            }

            val newsListResponse = async.await()
            newsListResponse
        }
    }
}