package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.App
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.Screens

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var app: Application = application

    fun goToPerson() {
        (app as App).router.navigateTo(Screens.Person())
    }
}