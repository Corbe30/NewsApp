package com.example.newsapp.Adapter

import androidx.recyclerview.widget.DiffUtil

class DiffCallback : DiffUtil.ItemCallback<Any>() {
    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return false
    }

    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return false
    }
}