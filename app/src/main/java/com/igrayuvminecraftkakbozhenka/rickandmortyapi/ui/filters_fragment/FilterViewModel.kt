package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.filters_fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.App
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.models.Filter
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.Screens

class FilterViewModel(app: Application): AndroidViewModel(app) {

    private var app: Application = app

    val name = MutableLiveData<String>()
    val status = MutableLiveData<String>()
    val species = MutableLiveData<String>()
    val gender = MutableLiveData<String>()

    fun goToPerson() {
        (app as App).router.navigateTo(Screens.Person())
    }

    fun setName(nameFromFragment: String) { name.value = nameFromFragment }

    fun setStatus(statusFromFragment: String) { status.value = statusFromFragment }

    fun setSpecies(speciesFromFragment: String) { species.value = speciesFromFragment }

    fun setGender(genderFromFragment: String) { gender.value = genderFromFragment }

    fun createFilter() {
        val filter = Filter(name.value, status.value, species.value, gender.value)
    }
}