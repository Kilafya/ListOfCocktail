package com.example.listofcocktail.presentation.cocktail_item

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listofcocktail.domain.model.CocktailFullInfo
import com.example.listofcocktail.domain.use_cases.GetCocktailByIdUseCase
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class CocktailItemViewModel @Inject constructor(
    private val getCocktailByIdUseCase: GetCocktailByIdUseCase
): ViewModel() {

    private val _state: MutableLiveData<CocktailItemState> = MutableLiveData()
    val state: LiveData<CocktailItemState>
        get() = _state

    init {
        _state.value = LoadingState
    }

    fun getCocktailFullInfo(id: String) {
        viewModelScope.launch {
            _state.value = try {
                ReadyState(getCocktailByIdUseCase(id))
            } catch (e: Exception) {
                ErrorState
            }
        }
    }

    fun getCategory(cocktailFullInfo: CocktailFullInfo): String {
        return "${cocktailFullInfo.category} (${cocktailFullInfo.alcoholic})"
    }
}