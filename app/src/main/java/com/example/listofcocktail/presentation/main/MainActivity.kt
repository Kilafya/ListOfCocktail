package com.example.listofcocktail.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listofcocktail.presentation.cocktail_list.CocktailListFragment
import com.example.listofcocktail.R
import com.example.listofcocktail.databinding.ActivityMainBinding
import com.example.listofcocktail.presentation.cocktail_item.CocktailItemFragment

class MainActivity : AppCompatActivity(), CocktailListFragment.Navigation {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        launchStartFragment()

    }

    private fun launchStartFragment() {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_container, CocktailListFragment.getInstance())
            .commit()
    }

    override fun showCocktailInfo(id: String) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_container, CocktailItemFragment.newInstance(id))
            .commit()
    }

    override fun exit() {
        finish()
    }
}