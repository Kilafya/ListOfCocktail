package com.example.listofcocktail.domain.repository

import com.example.listofcocktail.domain.model.CocktailFullInfo
import com.example.listofcocktail.domain.model.CocktailItem

interface CocktailRepository {
    suspend fun getCocktailList(): List<CocktailItem>

    suspend fun getCocktailListByName(name: String): List<CocktailItem>

    suspend fun getCocktailById(id: String): CocktailFullInfo
}