package com.example.listofcocktail.presentation.cocktail_item

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listofcocktail.R
import com.example.listofcocktail.databinding.ItemIngredientBinding
import kotlinx.android.synthetic.main.item_ingredient.view.*

class IngredientListAdapter: ListAdapter<String, IngredientViewHolder>(IngredientDiffCallback) {

    var ingredientList = emptyList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val binding = ItemIngredientBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return IngredientViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        with(holder.binding) {
            tvIngredientPosition.text = itemNumberToString(position)
            tvIngredientName.text = ingredientList[position]
        }
    }

    override fun getItemCount() = ingredientList.size

    private fun itemNumberToString(position: Int) = (position + 1).toString()
}