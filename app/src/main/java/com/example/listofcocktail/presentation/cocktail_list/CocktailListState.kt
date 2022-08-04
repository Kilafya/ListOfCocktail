package com.example.listofcocktail.presentation.cocktail_list

import com.example.listofcocktail.domain.model.CocktailItem

sealed class CocktailListState

object ErrorState: CocktailListState()

object LoadingState: CocktailListState()

data class ReadyState(
    val cocktailList: List<CocktailItem>
): CocktailListState()