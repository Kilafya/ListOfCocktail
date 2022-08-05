package com.example.listofcocktail.presentation.cocktail_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listofcocktail.data.repository.CocktailRepositoryImpl
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.Exception

class CocktailListViewModel: ViewModel() {

    private val repositoryImpl = CocktailRepositoryImpl()

    private val _drinkList: MutableLiveData<CocktailListState> = MutableLiveData()
    val drinkList: LiveData<CocktailListState>
        get() = _drinkList

    init {
        _drinkList.value = LoadingState
    }

    fun setCocktailList() {
        viewModelScope.launch {
            _drinkList.value = try {
                ReadyState(repositoryImpl.getCocktailList())
            } catch (e: Exception) {
                ErrorState
            }
        }
    }
}