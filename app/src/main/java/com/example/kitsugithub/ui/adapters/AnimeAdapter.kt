package com.example.kitsugithub.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitsugithub.base.BaseDiffUtilItemCallback
import com.example.kitsugithub.databinding.ItemAnimeBinding
import com.example.kitsugithub.models.DataItem

class AnimeAdapter : PagingDataAdapter<DataItem, AnimeAdapter.ViewHolder>(
    BaseDiffUtilItemCallback()
) {
    inner class ViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(attributes: DataItem) {
            binding.tvAnime.text = attributes.attributes.titles.enJp
            Glide.with(binding.itemImageAnime).load(attributes.attributes.posterImage.original)
                .into(binding.itemImageAnime)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}