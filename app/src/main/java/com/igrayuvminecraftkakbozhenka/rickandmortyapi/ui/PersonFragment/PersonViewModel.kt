package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.PersonFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.CharacterRepository
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.filtres.FiltersRepos
import kotlinx.coroutines.launch


class PersonViewModel(): ViewModel() {


    val characterCache = MutableLiveData<ArrayList<Character>>()
    val onceCharacter = MutableLiveData<Character>()
    val filteredCharacters: MutableLiveData<ArrayList<Character>> = FiltersRepos.filteredCharacters.

    private val repository = CharacterRepository.getInstance()


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