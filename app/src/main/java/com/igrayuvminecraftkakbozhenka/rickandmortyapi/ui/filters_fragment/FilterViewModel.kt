package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.filters_fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.filtres.FiltersRepos
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.filtres.Parameters

class FilterViewModel(app: Application): AndroidViewModel(app) {

    fun getFilteredCharacters() {
        FiltersRepos.getFilteredCharacters()
    }

}