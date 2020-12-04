package com.example.desafiowebservice.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Date (
        @SerializedName("date") val date: String,
        @SerializedName("type") val type: String
) : Serializable