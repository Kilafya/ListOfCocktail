package com.example.listofcocktail.domain.repository

import com.example.listofcocktail.domain.model.CocktailFullInfo
import com.example.listofcocktail.domain.model.CocktailItem

interface CocktailRepository {
    suspend fun getCocktailList(): List<CocktailItem>

    suspend fun getCocktailByName(name: String): CocktailFullInfo

    suspend fun getCocktailById(id: String): CocktailFullInfo
}