package com.updeveloped.marvelheroes.views.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.updeveloped.marvelheroes.databinding.CarouselItemBinding
import com.updeveloped.marvelheroes.helper.loadGlideUrl
import com.updeveloped.marvelheroes.domain.entities.CharacterDetail

class CarouselItemViewHolder(
    private val binding: CarouselItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(character: CharacterDetail) {
        binding.title.text = character.name
        //binding.description.text = character.description

        val basePath = character.thumbnail?.path
        val extension = "." + character.thumbnail?.extension

        binding
            .thumbnail
            .loadGlideUrl("$basePath$extension")
    }

    companion object {
        fun inflate(parent: ViewGroup) = CarouselItemViewHolder(
            CarouselItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}