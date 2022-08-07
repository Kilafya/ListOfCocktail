package com.example.listofcocktail.domain.use_cases

import com.example.listofcocktail.domain.repository.CocktailRepository
import javax.inject.Inject

class GetCocktailByIdUseCase @Inject constructor(
    private val repository: CocktailRepository
) {
    suspend operator fun invoke(id: String) = repository.getCocktailById(id)
}