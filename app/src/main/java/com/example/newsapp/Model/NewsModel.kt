package com.example.newsapp.Model

import com.example.newsapp.Model.Result

data class NewsModel(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)