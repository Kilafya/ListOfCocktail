package com.example.listofcocktail.data.api


import com.example.listofcocktail.data.model.DrinkList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(URL_COCKTAIL_LIST)
    suspend fun getDrinkList(): Response<DrinkList>
}