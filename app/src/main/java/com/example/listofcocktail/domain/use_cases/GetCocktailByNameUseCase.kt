package com.example.listofcocktail.domain.use_cases

import com.example.listofcocktail.domain.repository.CocktailRepository

class GetCocktailByNameUseCase(
    private val repository: CocktailRepository
) {
    suspend operator fun invoke(name: String) = repository.getCocktailByName(name)
}