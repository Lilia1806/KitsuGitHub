package com.example.kitsugithub.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.kitsugithub.base.BaseRepository
import com.example.kitsugithub.models.DataItem
import com.example.kitsugithub.remote.apiservices.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService
) : BaseRepository() {

    fun fetchAnime() = doRequest {
        animeApiService.fetchAnime()
    }

//    fun fetchAnime() = Pager(
//        PagingConfig(pageSize = 20, initialLoadSize = 10)
//    ) {
//        AnimePagingSource(animeApiService)
//    }.liveData
}