package com.example.kitsugithub.remote.apiservices

import com.example.kitsugithub.models.DataItem
import com.example.kitsugithub.models.KitsuResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiService {

    @GET("anime")
     suspend fun fetchAnime(
    ): KitsuResponse<DataItem>
}