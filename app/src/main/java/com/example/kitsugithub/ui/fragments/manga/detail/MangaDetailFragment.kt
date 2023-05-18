package com.example.kitsugithub.ui.fragments.manga.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsugithub.R
import com.example.kitsugithub.base.BaseFragment
import com.example.kitsugithub.databinding.FragmentMangaDetailBinding
import com.example.kitsugithub.extensions.setImage
import com.example.kitsugithub.ui.fragments.anime.detail.AnimeDetailFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment :
    BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(R.layout.fragment_manga_detail) {

    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    override val viewModel: MangaDetailViewModel by viewModels()
    private val args by navArgs<MangaDetailFragmentArgs>()

    override fun setupSubscribes() = with(binding) {
        viewModel.fetchMangaDetail(args.id).subscribe(
            onError = {
            },
            onSuccess = { it ->
                it.dataItem.let {
                 binding.imgMangaDetail.setImage(it.attributes.posterImage.original)
                    binding.tvMangaDetail.text = it.attributes.titles.enJp
                }
            }
        )
    }
}