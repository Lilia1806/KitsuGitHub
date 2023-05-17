package com.example.kitsugithub.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsugithub.R
import com.example.kitsugithub.base.BaseFragment
import com.example.kitsugithub.databinding.FragmentMangaBinding
import com.example.kitsugithub.ui.adapters.MangaAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment :
    BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private var mangaAdapter = MangaAdapter()

    override fun initialize() {
        binding.rvManga.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = mangaAdapter
        }
    }

    override fun setupSubscribes() {
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                mangaAdapter.submitData(it)
            }
        }
    }
}