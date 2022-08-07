package com.example.listofcocktail.presentation.cocktail_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listofcocktail.domain.model.CocktailFullInfo
import com.example.listofcocktail.domain.use_cases.GetCocktailByIdUseCase
import com.example.listofcocktail.domain.use_cases.GetCocktailListUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class CocktailListViewModel @Inject constructor(
    private val getCocktailListUseCase: GetCocktailListUseCase,
): ViewModel() {

    private val _state: MutableLiveData<CocktailListState> = MutableLiveData()
    val state: LiveData<CocktailListState>
        get() = _state

    init {
        _state.value = LoadingState
    }

    fun setCocktailList() {
        viewModelScope.launch {
            _state.value = try {
                ReadyState(getCocktailListUseCase())
            } catch (e: Exception) {
                ErrorState
            }
        }
    }
}