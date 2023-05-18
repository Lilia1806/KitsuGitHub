package com.example.kitsugithub.ui.fragments.manga

import com.example.kitsugithub.base.BaseViewModel
import com.example.kitsugithub.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val mangaRepository: MangaRepository
) : BaseViewModel() {

    fun fetchManga() = mangaRepository.fetchManga()
}