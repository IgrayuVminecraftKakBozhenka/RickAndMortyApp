package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.menu

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.App
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.Screens

class MenuViewModel(application: Application) : AndroidViewModel(application) {
    private var app: Application = application

    fun goToPerson() {
        (app as App).router.navigateTo(Screens.Person())
    }

    fun goToFilter() {
        (app as App).router.navigateTo(Screens.Filters())
    }
}