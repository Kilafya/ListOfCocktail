package com.example.listofcocktail.di.module

import com.example.listofcocktail.data.repository.CocktailRepositoryImpl
import com.example.listofcocktail.di.annotation.ApplicationScope
import com.example.listofcocktail.domain.repository.CocktailRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {
    @Binds
    @ApplicationScope
    fun bindCocktailRepository(impl: CocktailRepositoryImpl): CocktailRepository
}