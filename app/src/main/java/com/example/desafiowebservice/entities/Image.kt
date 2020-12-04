package com.example.desafiowebservice.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Image (
        @SerializedName("path") val path: String,
        @SerializedName("extension") val extension: String
) : Serializable {
    override fun toString() = "$path.$extension".replace("http://", "https://")
}