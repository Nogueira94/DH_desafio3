package com.example.desafiowebservice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.desafiowebservice.R
import com.example.desafiowebservice.adapter.ComicAdapter
import com.example.desafiowebservice.services.marvelAPI
import com.example.desafiowebservice.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    lateinit var comicAdapter : ComicAdapter

    val viewModel by viewModels<HomeViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return HomeViewModel(marvelAPI) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        comicAdapter = ComicAdapter()
        rvComics.adapter = comicAdapter
        rvComics.layoutManager = GridLayoutManager(this,3)
        rvComics.setHasFixedSize(true)

        viewModel.getComics()

//        viewModel.listComics.observe(this){
//            viewModel.getComics()
//        }

    }
}