package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.filters_fragment

import android.app.Application
import android.text.Editable
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.App
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.DataRepository
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.models.Filter
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.Screens

class FilterViewModel(app: Application): AndroidViewModel(app) {

    private var app: Application = app
    private val repository = DataRepository.getInstance()

    val name = MutableLiveData<String>()
    val status = MutableLiveData<DataRepository.StatusValue>()
    val species = MutableLiveData<DataRepository.SpeciesValue>()
    val gender = MutableLiveData<DataRepository.GenderValue>()

    fun goToPerson() {
        createFilter()
        (app as App).router.navigateTo(Screens.Person())
    }

    fun setName(nameResId: String) { name.value = nameResId }

    fun setStatus(statusValue: DataRepository.StatusValue ) { status.value = statusValue }
    fun clearStatus() { status.value = null}

    fun setSpecies(speciesValue: DataRepository.SpeciesValue) { species.value = speciesValue }
    fun clearSpecies() {species.value = null}

    fun setGender(genderValue: DataRepository.GenderValue) { gender.value = genderValue }
    fun clearGender() {gender.value = null}

    private fun createFilter() {
        Log.d("value", status.value?.value.toString())
        val filter = Filter(name.value, status.value?.value, species.value?.value, gender.value?.value)
        repository?.filter = filter
    }
}