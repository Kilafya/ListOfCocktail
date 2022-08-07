package com.example.listofcocktail.presentation.main

import android.app.Application
import com.example.listofcocktail.di.DaggerApplicationComponent

class CocktailApp: Application() {
    val component by lazy {
        DaggerApplicationComponent.create()
    }
}