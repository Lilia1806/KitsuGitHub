package com.example.kitsugithub.repositories


import com.example.kitsugithub.base.BaseRepository
import com.example.kitsugithub.remote.apiservices.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService
) : BaseRepository() {

    fun fetchAnime() = doRequest {
        animeApiService.fetchAnime()
    }

    fun fitchDetailAnime(id: String) = doRequest {
        animeApiService.fitchDetailAnime(id)
    }
}