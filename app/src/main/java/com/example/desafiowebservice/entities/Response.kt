package com.example.desafiowebservice.entities

import com.google.gson.annotations.SerializedName

data class ApiResponse<T> (
        @SerializedName("data") val data: Data<T>
)