package com.example.newsapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel  : ViewModel() {
    val newsRepo = NewsListRepo()
    val newsList: MutableLiveData<List<Result>> = MutableLiveData()

    fun getNewsList() {
        viewModelScope.launch {
            try {
                val response = newsRepo.fetchMovieData()
                if (response != null) {
                    onGetMovieListResponseSuccess(response)
                    println(newsList)
                }
            } catch (e: Exception) {

            }
        }
    }

    fun onGetMovieListResponseSuccess(response: NewsModel) {
        newsList.value = response.results
    }
}