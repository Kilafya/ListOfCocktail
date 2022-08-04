package com.example.listofcocktail.data.repository

import com.example.listofcocktail.data.api.RetrofitInstance

class CocktailRepositoryImpl {

    suspend fun getDrinkList() = RetrofitInstance.api.getDrinkList()
}