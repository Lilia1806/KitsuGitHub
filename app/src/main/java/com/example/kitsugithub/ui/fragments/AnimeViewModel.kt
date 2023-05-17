package com.example.kitsugithub.ui.fragments

import com.example.kitsugithub.base.BaseViewModel
import com.example.kitsugithub.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : BaseViewModel() {

    fun fetchAnime() = animeRepository.fetchAnime()
}