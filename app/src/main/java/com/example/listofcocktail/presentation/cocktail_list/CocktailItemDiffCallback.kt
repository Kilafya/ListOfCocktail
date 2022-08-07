package com.example.listofcocktail.presentation.cocktail_list

import androidx.recyclerview.widget.DiffUtil
import com.example.listofcocktail.domain.model.CocktailItem

object CocktailItemDiffCallback: DiffUtil.ItemCallback<CocktailItem>() {
    override fun areItemsTheSame(oldItem: CocktailItem, newItem: CocktailItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CocktailItem, newItem: CocktailItem): Boolean {
        return oldItem == newItem
    }
}