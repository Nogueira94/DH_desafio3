package com.example.desafiowebservice.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiowebservice.entities.Comic
import com.example.desafiowebservice.services.ServiceMarvelAPI
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel(val marvelAPI : ServiceMarvelAPI) : ViewModel() {
    val listComics = MutableLiveData<ArrayList<Comic>>()

    fun getComics(){
        viewModelScope.launch {
            try{
                listComics.value = marvelAPI.getResults(

                )

            } catch (e: Exception){
                Log.e("HomeViewHolder", e.toString())
            }
        }
    }

}