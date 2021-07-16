package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.person_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.CharacterRepository
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.filtres.FiltersRepos
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class PersonViewModel: ViewModel() {


    val characterCache = MutableLiveData<ArrayList<Character>>()
    val onceCharacter = MutableLiveData<Character>()
    private val repository = CharacterRepository.getInstance()

    fun getFilteredCharacters(): Flow<ArrayList<Character>> {
        return FiltersRepos.getFilteredCharacters()
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