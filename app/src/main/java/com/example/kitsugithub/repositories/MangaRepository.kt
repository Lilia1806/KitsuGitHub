package com.example.kitsugithub.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.kitsugithub.base.BaseRepository
import com.example.kitsugithub.remote.apiservices.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiService: MangaApiService
) : BaseRepository() {

    fun fetchManga() = doRequest {
        mangaApiService.fetchManga()
    }

//    fun fetchManga() = Pager(
//        PagingConfig(pageSize = 20, initialLoadSize = 10)
//    ) {
//        MangaPagingSource(mangaApiService)
//    }.liveData
}