package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.filters_fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.App
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.filtres.FiltersRepos
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.filtres.Parameters
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.Screens

class FilterViewModel(app: Application): AndroidViewModel(app) {

    private var app: Application = app

    fun goToPerson() {
        (app as App).router.navigateTo(Screens.Person())
    }

}