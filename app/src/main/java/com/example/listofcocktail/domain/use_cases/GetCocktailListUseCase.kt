package com.example.listofcocktail.domain.use_cases

import com.example.listofcocktail.domain.repository.CocktailRepository

class GetCocktailListUseCase(
    private val repository: CocktailRepository
) {
    suspend operator fun invoke() = repository.getCocktailList()
}