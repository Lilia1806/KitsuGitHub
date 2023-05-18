package com.example.kitsugithub.repositories

import com.example.kitsugithub.base.BaseRepository
import com.example.kitsugithub.remote.apiservices.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiService: MangaApiService
) : BaseRepository() {

    fun fetchManga() = doRequest {
        mangaApiService.fetchManga()
    }

    fun fitchDetailManga(id: String) = doRequest {
        mangaApiService.fitchDetailManga(id)
    }
}