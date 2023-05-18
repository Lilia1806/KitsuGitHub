package com.example.kitsugithub.ui.fragments.anime.detail

import com.example.kitsugithub.base.BaseViewModel
import com.example.kitsugithub.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor (
    private val animeRepository: AnimeRepository
) : BaseViewModel() {

    fun fetchAnimeDetail(id: String) = animeRepository.fitchDetailAnime(id)
}