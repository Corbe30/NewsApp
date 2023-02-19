package com.example.newsapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.Adapter.NewsListAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    val adapter = NewsListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initData()
        initViewModelObserver()
        initAdapter()
    }

    fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    fun initData() {
        viewModel.getNewsList()
    }

    fun initViewModelObserver() {
        viewModel.newsList.observe(viewLifecycleOwner,  { onGetNewsResponse(it) })
    }

    fun onGetNewsResponse(response : List<Result>?){
        if (resultResponse != null) {
            adapterListSubmit(resultResponse)
        }
    }

    fun initAdapter() {
        linearLayoutManager = LinearLayoutManager(activity , RecyclerView.VERTICAL , false)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = linearLayoutManager
    }

}