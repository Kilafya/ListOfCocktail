package com.example.listofcocktail.domain.model

data class CocktailFullInfo(
    val id: String,
    val name: String,
    val category: String,
    val alcoholic: String,
    val glass: String,
    val instruction: String,
    val ingredients: List<String>,
    val imageUrl: String
) {
    companion object {

        private const val EMPTY_STRING = ""

        val EMPTY = CocktailFullInfo (
            id = EMPTY_STRING,
            name = EMPTY_STRING,
            category = EMPTY_STRING,
            alcoholic = EMPTY_STRING,
            glass = EMPTY_STRING,
            instruction = EMPTY_STRING,
            ingredients = emptyList(),
            imageUrl = EMPTY_STRING
        )

        fun isEmpty(cocktailFullInfo: CocktailFullInfo) = cocktailFullInfo.id == EMPTY_STRING
    }
}
