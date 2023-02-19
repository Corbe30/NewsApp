package com.example.newsapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.databinding.CardBinding
import com.example.newsapp.model.Result

class NewsListViewHolder(val binding: CardBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object{
        fun create(inflater: LayoutInflater,
                   viewGroup: ViewGroup) : MovieListViewHolder {
            val binding = DataBindingUtil.inflate<CardBinding>(inflater, R.layout.card , viewGroup ,false)
            return MovieListViewHolder(binding)
        }
    }
    private val photo: ImageView = binding.moviePhoto
    //    private val title: TextView = binding.movieTitle
//    private val overview: TextView = binding.movieOverview
//    private val rating: TextView = binding.movieRating
//
    fun bind(movie: Result) {
        print("Bind")


        val titleText = "Title: "+movie.title
        val ratingText = "Rating : "+movie.vote_average.toString()
        val overviewText = movie.overview

        binding.movieTitle.text = titleText
        binding.movieOverview.text = overviewText
        binding.movieRating.text = ratingText
        Glide.with(photo).load("https://image.tmdb.org/t/p/w500${movie.poster_path}").into(photo)
    }

}