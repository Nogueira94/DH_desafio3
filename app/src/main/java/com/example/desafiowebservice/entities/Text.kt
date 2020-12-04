package com.example.desafiowebservice.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Text (
        @SerializedName("text") val text: String,
) : Serializable