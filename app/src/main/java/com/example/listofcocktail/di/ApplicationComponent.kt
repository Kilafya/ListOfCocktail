package com.example.listofcocktail.di

import com.example.listofcocktail.di.annotation.ApplicationScope
import com.example.listofcocktail.di.module.DataModule
import com.example.listofcocktail.di.module.ViewModelModule
import com.example.listofcocktail.presentation.cocktail_item.CocktailItemFragment
import com.example.listofcocktail.presentation.cocktail_list.CocktailListFragment
import dagger.Component

@Component(modules = [ViewModelModule::class, DataModule::class])
@ApplicationScope
interface ApplicationComponent {
    fun inject(fragment: CocktailListFragment)

    fun inject(fragment: CocktailItemFragment)
}