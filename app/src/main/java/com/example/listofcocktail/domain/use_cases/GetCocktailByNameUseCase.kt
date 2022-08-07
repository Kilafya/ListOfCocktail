package com.example.listofcocktail.domain.use_cases

import com.example.listofcocktail.domain.repository.CocktailRepository
import javax.inject.Inject

class GetCocktailByNameUseCase @Inject constructor(
    private val repository: CocktailRepository
) {
    suspend operator fun invoke(name: String) = repository.getCocktailListByName(name)
}