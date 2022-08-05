package com.example.listofcocktail.data.repository

import com.example.listofcocktail.data.api.RetrofitInstance
import com.example.listofcocktail.data.mapper.CocktailMapper
import com.example.listofcocktail.domain.model.CocktailFullInfo
import com.example.listofcocktail.domain.model.CocktailItem
import com.example.listofcocktail.domain.repository.CocktailRepository

class CocktailRepositoryImpl: CocktailRepository {

    private val mapper = CocktailMapper()

    override suspend fun getCocktailList(): List<CocktailItem> {
        val response = RetrofitInstance.api.getDrinkList()
        return response.body()?.let {
            mapper.mapDrinkListToCocktailList(it)
        } ?: emptyList()
    }

    override suspend fun getCocktailByName(name: String): CocktailFullInfo {
        TODO("Not yet implemented")
    }

    override suspend fun getCocktailById(id: String): CocktailFullInfo {
        TODO("Not yet implemented")
    }
}