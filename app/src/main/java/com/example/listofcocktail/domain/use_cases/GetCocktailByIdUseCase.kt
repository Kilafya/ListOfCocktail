package com.example.listofcocktail.domain.use_cases

import com.example.listofcocktail.domain.repository.CocktailRepository

class GetCocktailByIdUseCase (
    private val repository: CocktailRepository
) {
    suspend operator fun invoke(id: String) = repository.getCocktailById(id)
}