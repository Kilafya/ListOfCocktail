package com.example.listofcocktail.presentation.cocktail_list

import android.view.LayoutInflater

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listofcocktail.R
import com.example.listofcocktail.databinding.ItemCocktailLayoutBinding
import com.example.listofcocktail.domain.model.CocktailItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_cocktail_layout.view.*

class CocktailListAdapter:
    ListAdapter<CocktailItem, CocktailListViewHolder>(CocktailItemDiffCallback) {

    var cocktailList = emptyList<CocktailItem>()

    var clickListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailListViewHolder {
        val binding = ItemCocktailLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CocktailListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CocktailListViewHolder, position: Int) {
        val cocktail = cocktailList[position]

        with(holder.binding) {
            tvItemName.text = cocktail.name
            loadImage(ivItemImage, cocktail.imageUrl)
            root.setOnClickListener{
                clickListener?.invoke(cocktail.id)
            }
        }
    }

    override fun getItemCount() = cocktailList.size

    private fun loadImage(imageView: ImageView, url: String) = Picasso.with(imageView.context)
        .load(url)
        .placeholder(R.drawable.ic_cocktail_default)
        .error(R.drawable.ic_cocktail_default)
        .into(imageView)
}