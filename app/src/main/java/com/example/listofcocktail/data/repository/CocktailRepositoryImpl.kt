package com.example.listofcocktail.data.repository

import com.example.listofcocktail.data.api.RetrofitInstance
import com.example.listofcocktail.data.mapper.CocktailMapper
import com.example.listofcocktail.domain.model.CocktailFullInfo
import com.example.listofcocktail.domain.model.CocktailItem
import com.example.listofcocktail.domain.repository.CocktailRepository
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(): CocktailRepository {

    private val mapper = CocktailMapper()

    override suspend fun getCocktailList(): List<CocktailItem> {
        val response = RetrofitInstance.api.getDrinkList()
        return response.body()?.let {
            mapper.mapDrinkListToCocktailList(it)
        } ?: emptyList()
    }

    override suspend fun getCocktailListByName(name: String): List<CocktailItem> {
        val response = RetrofitInstance.api.getDrinkFullInfoByName(name)
        return response.body()?.let { drinkFullInfo ->
            mapper.mapDrinkFullInfoToCocktailList(drinkFullInfo)
        } ?: emptyList()
    }

    override suspend fun getCocktailById(id: String): CocktailFullInfo {
        val response = RetrofitInstance.api.getDrinkFullInfoById(id)
        return response.body()?.let { mapper.mapDrinkXToCocktailFullInfo(it.drinks[0]) }
            ?: CocktailFullInfo.EMPTY
    }
}