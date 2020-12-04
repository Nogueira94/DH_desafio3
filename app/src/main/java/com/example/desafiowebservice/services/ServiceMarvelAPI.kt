package com.example.desafiowebservice.services
import com.google.gson.JsonObject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ServiceMarvelAPI{

    @GET("characters/{characterId}/comics")
    suspend fun getResults(
        @Path("characterId") characterId : Int = 1009610,
        @Query("offset")offset: Int,
        @Query("limit")limit: Int,
        @Query("ts") ts: Long,
        @Query("apikey")apiKey: String,
        @Query("hash")hash: String
    ): JsonObject
}

val urlApiMarvel = "https://gateway.marvel.com/v1/public/"

val retrofit = Retrofit.Builder()
    .baseUrl(urlApiMarvel)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val marvelAPI = retrofit.create(ServiceMarvelAPI::class.java)
