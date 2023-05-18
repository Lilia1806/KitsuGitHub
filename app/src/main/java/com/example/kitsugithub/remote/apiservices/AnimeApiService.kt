package com.example.kitsugithub.remote.apiservices

import com.example.kitsugithub.models.DataItem
import com.example.kitsugithub.models.Detail
import com.example.kitsugithub.models.KitsuResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {

    @GET("anime")
     suspend fun fetchAnime(
    ): KitsuResponse<DataItem>

    @GET("anime/{id}")
    suspend fun fitchDetailAnime(
        @Path("id") id: String
    ): Detail
}