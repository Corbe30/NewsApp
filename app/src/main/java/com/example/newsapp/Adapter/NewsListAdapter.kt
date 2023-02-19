package com.example.newsapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R

class NewsListAdapter  : ListAdapter<Any, RecyclerView.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        var viewHolder : RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(parent.context)
        when(viewType){
            R.layout.card -> viewHolder = MovieListViewHolder.create(inflater, parent)
        }
        return  (viewHolder as MovieListViewHolder?)!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        print("On BindViewHOlder")
        val item = getItem(position)
        when(holder){
            is MovieListViewHolder -> holder.bind(item as Result)
        }
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        val item = getItem(position)
        var itemViewType = 0
        when(item){
            is Result -> itemViewType = R.layout.card
        }
        return itemViewType
    }

    public override fun getItem(position: Int): Any {
        return super.getItem(position)
    }
}