package com.example.kitsugithub.repositories.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import com.example.kitsugithub.base.BasePagingSource
import com.example.kitsugithub.models.DataItem
import com.example.kitsugithub.remote.apiservices.AnimeApiService

private const val ANIME_STARTING_PAGE_INDEX = 1

class AnimePagingSource(private val animeService: AnimeApiService) : BasePagingSource<DataItem>() {

    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, DataItem> {
        return try {
            val nextPage = params.key ?: ANIME_STARTING_PAGE_INDEX
            val response = animeService.fetchAnime(params.loadSize, nextPage)
            val nextPages =
                Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()

            PagingSource.LoadResult.Page(
                data = response.data,
                prevKey = if (nextPage == 1) null
                else nextPage - 1,
                nextKey = nextPages
            )
        } catch (e: Exception) {
            PagingSource.LoadResult.Error(e)
        }
    }
}