package com.example.listofcocktail.domain.use_cases

import com.example.listofcocktail.domain.repository.CocktailRepository
import javax.inject.Inject

class GetCocktailListUseCase @Inject constructor(
    private val repository: CocktailRepository
) {
    suspend operator fun invoke() = repository.getCocktailList()
}