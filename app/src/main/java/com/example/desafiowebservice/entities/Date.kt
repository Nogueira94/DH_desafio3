package com.example.desafiowebservice.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.Date

class Date(
        @SerializedName("date") val date: String,
        @SerializedName("type") val type: String
) : Serializable {
    fun getComicDate(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val final = SimpleDateFormat("MMM dd, yyyy")
        val _date = sdf.parse(date)
        return final.format(_date)
    }
}