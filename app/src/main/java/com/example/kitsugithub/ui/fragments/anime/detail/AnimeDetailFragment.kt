package com.example.kitsugithub.ui.fragments.anime.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsugithub.R
import com.example.kitsugithub.base.BaseFragment
import com.example.kitsugithub.databinding.FragmentAnimeDetailBinding
import com.example.kitsugithub.extensions.setImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment :
    BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>(R.layout.fragment_anime_detail) {

    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    override val viewModel: AnimeDetailViewModel by viewModels()
    private val args by navArgs<AnimeDetailFragmentArgs>()

    override fun setupSubscribes() = with(binding) {
        viewModel.fetchAnimeDetail(args.id).subscribe(
            onError = {
            },
            onSuccess = { it ->
                it.dataItem.let {
                    imgAnimeDetail.setImage(it.attributes.posterImage.original)
                    tvAnimeDetail.text = it.attributes.titles.enJp
                }
            }
        )
    }
}