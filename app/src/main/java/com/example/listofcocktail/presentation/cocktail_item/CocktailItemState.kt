package com.example.listofcocktail.presentation.cocktail_item

import com.example.listofcocktail.domain.model.CocktailFullInfo

sealed class CocktailItemState

object LoadingState: CocktailItemState()

object ErrorState: CocktailItemState()

data class ReadyState(
    val cocktailFullInfo: CocktailFullInfo
): CocktailItemState()
