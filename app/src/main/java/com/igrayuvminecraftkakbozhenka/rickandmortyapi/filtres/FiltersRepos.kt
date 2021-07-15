package com.igrayuvminecraftkakbozhenka.rickandmortyapi.filtres

import android.util.Log
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import java.lang.Exception


object FiltersRepos {

    val filteredCharacters = MutableSharedFlow<ArrayList<Character>>()
    private val repository = CharacterRepository.getInstance()

    suspend fun getFilteredCharacters() {

        val characters = repository?.getFilteredCharacters()
        try {
            filteredCharacters.emit(characters!!)
        } catch (e: Exception) { Log.d("null", "null") }
    }

}