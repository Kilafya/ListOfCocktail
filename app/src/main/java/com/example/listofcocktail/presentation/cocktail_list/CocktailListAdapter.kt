package com.example.listofcocktail.presentation.cocktail_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listofcocktail.R
import com.example.listofcocktail.domain.model.CocktailItem
import kotlinx.android.synthetic.main.item_cocktail_layout.view.*

class CocktailListAdapter: RecyclerView.Adapter<CocktailListAdapter.CocktailViewHolder>() {

    private var cocktailList = emptyList<CocktailItem>() // Надо изменить, чтобы presentation cлой не зависил от data

    class CocktailViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cocktail_layout, parent, false)
        return CocktailViewHolder(view)
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        holder.itemView.tv_item_name.text = cocktailList[position].name
        holder.itemView.iv_item_image.setImageResource(R.drawable.coctail_image)
    }

    override fun getItemCount() = cocktailList.size

    fun setCocktailsList(list: List<CocktailItem>) {
        cocktailList = list
        notifyDataSetChanged()
    }
}