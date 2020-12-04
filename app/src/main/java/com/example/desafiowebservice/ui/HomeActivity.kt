package com.example.desafiowebservice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiowebservice.R
import com.example.desafiowebservice.adapter.ComicAdapter
import com.example.desafiowebservice.services.marvelAPI
import com.example.desafiowebservice.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    lateinit var comicAdapter : ComicAdapter
    lateinit var gridLayoutManager: GridLayoutManager

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
        gridLayoutManager = GridLayoutManager(this,3)
        rvComics.adapter = comicAdapter
        rvComics.layoutManager = GridLayoutManager(this, 3)
        rvComics.hasFixedSize()

        viewModel.listComics.observe(this,){
            comicAdapter.addComic(it)
        }

        viewModel.getComics()

        setScroller()

    }

    fun setScroller(){
        rvComics.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy > 0){
                    val litem = gridLayoutManager.itemCount
                    val vItem  = gridLayoutManager.findFirstCompletelyVisibleItemPosition()
                    val itens = comicAdapter.itemCount
                    if(litem + vItem >= itens){
                        Log.i("TAG", "teste")
                    }
                }
            }
        })
    }

}