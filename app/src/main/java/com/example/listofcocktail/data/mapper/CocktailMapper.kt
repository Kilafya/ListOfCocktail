package com.example.listofcocktail.data.mapper

import com.example.listofcocktail.data.model.Drink
import com.example.listofcocktail.data.model.DrinkList
import com.example.listofcocktail.domain.model.CocktailItem

class CocktailMapper {

    fun mapDrinkToCocktailItem(drink: Drink): CocktailItem {
        return CocktailItem(
            id = drink.idDrink,
            name = drink.strDrink,
            imageUrl = drink.strDrinkThumb
        )
    }

    fun mapDrinkListToCocktailList(drinkList: DrinkList): List<CocktailItem> {
        return drinkList.drinks.map { mapDrinkToCocktailItem(it) }
    }
}