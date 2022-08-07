package com.example.listofcocktail.data.mapper

import com.example.listofcocktail.data.model.Drink
import com.example.listofcocktail.data.model.DrinkFullInfoList
import com.example.listofcocktail.data.model.DrinkList
import com.example.listofcocktail.data.model.DrinkX
import com.example.listofcocktail.domain.model.CocktailFullInfo
import com.example.listofcocktail.domain.model.CocktailItem

class CocktailMapper {

    private fun mapDrinkToCocktailItem(drink: Drink): CocktailItem {
        return CocktailItem(
            id = drink.idDrink,
            name = drink.strDrink,
            imageUrl = drink.strDrinkThumb
        )
    }

    fun mapDrinkListToCocktailList(drinkList: DrinkList): List<CocktailItem> {
        return drinkList.drinks.map { mapDrinkToCocktailItem(it) }
    }

    private fun getIngredientsList(drinkFullInfo: DrinkX): List<String> {
        val ingredients = mutableListOf<String>()
        drinkFullInfo.strIngredient1?.let { ingredients.add(it) }
        drinkFullInfo.strIngredient2?.let { ingredients.add(it) }
        drinkFullInfo.strIngredient3?.let { ingredients.add(it) }
        drinkFullInfo.strIngredient4?.let { ingredients.add(it) }
        drinkFullInfo.strIngredient5?.let { ingredients.add(it) }
        drinkFullInfo.strIngredient6?.let { ingredients.add(it) }
        drinkFullInfo.strIngredient7?.let { ingredients.add(it) }
        drinkFullInfo.strIngredient8?.let { ingredients.add(it) }
        drinkFullInfo.strIngredient9?.let { ingredients.add(it) }
        drinkFullInfo.strIngredient10?.let { ingredients.add(it) }
        drinkFullInfo.strIngredient11?.let { ingredients.add(it) }
        drinkFullInfo.strIngredient12?.let { ingredients.add(it) }
        drinkFullInfo.strIngredient13?.let { ingredients.add(it) }
        drinkFullInfo.strIngredient14?.let { ingredients.add(it) }
        drinkFullInfo.strIngredient15?.let { ingredients.add(it) }
        return ingredients
    }

    fun mapDrinkXToCocktailFullInfo(drinkFullInfo: DrinkX): CocktailFullInfo {
        return CocktailFullInfo(
            id = drinkFullInfo.idDrink,
            name = drinkFullInfo.strDrink,
            category = drinkFullInfo.strCategory,
            alcoholic = drinkFullInfo.strAlcoholic,
            glass = drinkFullInfo.strGlass,
            instruction = drinkFullInfo.strInstructions,
            ingredients = getIngredientsList(drinkFullInfo),
            imageUrl = drinkFullInfo.strDrinkThumb
        )
    }

    private fun mapDrinkXToCocktailItem(drinkFullInfo: DrinkX): CocktailItem {
        return CocktailItem(
            id = drinkFullInfo.idDrink,
            name = drinkFullInfo.strDrink,
            imageUrl = drinkFullInfo.strDrinkThumb
        )
    }

    fun mapDrinkFullInfoToCocktailList(drinkList: DrinkFullInfoList): List<CocktailItem> {
        return drinkList.drinks.map { mapDrinkXToCocktailItem(it) }
    }
}