package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.App
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.constants.Screens
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests.RequestToAPI

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var app: Application = application

    fun goToPerson() {
        (app as App).router.navigateTo(Screens.Person())
    }
}