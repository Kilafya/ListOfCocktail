package com.example.listofcocktail.di.module

import androidx.lifecycle.ViewModel
import com.example.listofcocktail.di.annotation.ViewModelKey
import com.example.listofcocktail.presentation.cocktail_item.CocktailItemViewModel
import com.example.listofcocktail.presentation.cocktail_list.CocktailListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CocktailListViewModel::class)
    fun bindCocktailListViewModel(impl: CocktailListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CocktailItemViewModel::class)
    fun bindCocktailItemViewModel(impl: CocktailItemViewModel): ViewModel
}