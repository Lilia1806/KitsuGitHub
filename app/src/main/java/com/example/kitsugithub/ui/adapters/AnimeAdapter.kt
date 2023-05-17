package com.example.kitsugithub.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kitsugithub.base.BaseDiffUtilItemCallback
import com.example.kitsugithub.databinding.ItemKitsuBinding
import com.example.kitsugithub.models.DataItem

class AnimeAdapter : PagingDataAdapter<DataItem, AnimeAdapter.ViewHolder>(
    BaseDiffUtilItemCallback()
) {
    inner class ViewHolder(private val binding: ItemKitsuBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(attributes: DataItem) {
            binding.tvKitsu.text = attributes.attributes.titles.enJp
            Glide.with(binding.itemImageKitsu).load(attributes.attributes.posterImage.original)
                .into(binding.itemImageKitsu)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemKitsuBinding.inflate(
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