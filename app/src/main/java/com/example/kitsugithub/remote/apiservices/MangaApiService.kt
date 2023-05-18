package com.example.kitsugithub.remote.apiservices

import com.example.kitsugithub.models.DataItem
import com.example.kitsugithub.models.Detail
import com.example.kitsugithub.models.KitsuResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(
    ): KitsuResponse<DataItem>

    @GET("manga/{id}")
    suspend fun fitchDetailManga(
        @Path("id") id: String
    ): Detail
}