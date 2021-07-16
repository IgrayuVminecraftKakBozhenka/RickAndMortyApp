package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.person_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.Character
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.CharacterRepository
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.filtres.FiltersRepos
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.filtres.FiltersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class PersonViewModel: ViewModel() {


    val characterCache = MutableLiveData<ArrayList<Character>>()
    val onceCharacter = MutableLiveData<Character>()

    private val repository = CharacterRepository.getInstance()
    private val filtersRepository = FiltersRepository.getInstance()

    fun chekFilters() {
        viewModelScope.launch {
            val filter = filtersRepository?.getMeFiltersIfExist()
            if ( filter != null) {
                val characters = repository?.getFilteredCharacters()
            }
        }
    }


    fun getNewRandomCharacter() {
        viewModelScope.launch {
            val id = (0..671).random()
            val character = repository!!.getOnceCharacter(id)
            onceCharacter.postValue(character)
        }
    }

    fun getPageWithCharacters() {
        viewModelScope.launch {
            val pageId = (0..34).random()
            val characters = repository!!.getPageWithCharacters(pageId)
            characterCache.postValue(characters)
        }
    }

    fun clearCache() {
        repository?.clearRepository()
        characterCache.value?.clear()
    }
}