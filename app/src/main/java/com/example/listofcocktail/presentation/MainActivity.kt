package com.example.listofcocktail.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listofcocktail.presentation.cocktail_list.CocktailListFragment
import com.example.listofcocktail.R
import com.example.listofcocktail.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

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

}