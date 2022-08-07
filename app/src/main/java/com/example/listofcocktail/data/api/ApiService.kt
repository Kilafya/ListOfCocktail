package com.example.listofcocktail.data.api


import com.example.listofcocktail.data.model.DrinkFullInfoList
import com.example.listofcocktail.data.model.DrinkList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(URL_COCKTAIL_LIST)
    suspend fun getDrinkList(): Response<DrinkList>

    @GET(URL_COCKTAIL_BY_ID)
    suspend fun getDrinkFullInfoById(@Query("i") id: String): Response<DrinkFullInfoList>

    @GET(URL_COCKTAIL_BY_NAME)
    suspend fun getDrinkFullInfoByName(@Query("s") name: String): Response<DrinkFullInfoList>
}