package com.example.listofcocktail.presentation.cocktail_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listofcocktail.data.model.DrinkList
import com.example.listofcocktail.data.repository.CocktailRepositoryImpl
import kotlinx.coroutines.launch
import retrofit2.Response

class CocktailListViewModel: ViewModel() {

    private val repositoryImpl = CocktailRepositoryImpl()

    private val _drinkList: MutableLiveData<Response<DrinkList>> = MutableLiveData()
    val drinkList: LiveData<Response<DrinkList>>
        get() = _drinkList

    fun getDrinkList() {
        viewModelScope.launch {
            _drinkList.value = repositoryImpl.getDrinkList()
        }
    }
}