package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()
    }
    private fun initFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag, MainFragment.newInstance()).commitNow()
    }
}