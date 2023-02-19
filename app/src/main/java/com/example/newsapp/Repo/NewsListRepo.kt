package com.example.newsapp.Repo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class NewsListRepo {
    suspend fun fetchMovieData() : NewsModel?{
        val retrofit = RetrofitClient().getInstance()
        val request = retrofit.create(RetrofitServices::class.java)

//        val call = request.getMovies("b5a7aaff88a786d4924db7b0c9f8596e")
        println("outside call")
        return withContext(Dispatchers.IO){
            val async = async {
                request.getMovies("b5a7aaff88a786d4924db7b0c9f8596e")
            }

            val movieListResponse = async.await()
            movieListResponse
        }
}