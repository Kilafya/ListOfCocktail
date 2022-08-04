package com.example.listofcocktail.domain.model

data class CocktailFullInfo(
    val id: String,
    val name: String,
    val category: String,
    val alcoholic: String,
    val glass: String,
    val instruction: String,
    val ingredients: List<String>
)
