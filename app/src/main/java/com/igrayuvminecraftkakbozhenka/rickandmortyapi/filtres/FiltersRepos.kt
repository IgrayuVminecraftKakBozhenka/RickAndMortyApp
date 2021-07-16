package com.igrayuvminecraftkakbozhenka.rickandmortyapi.filtres

import android.util.Log
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import java.lang.Exception


object FiltersRepos {


    private val repository = CharacterRepository.getInstance()

    fun getFilteredCharacters(): Flow<ArrayList<Character>> = flow {
        try {
            val filteredCharacters = repository!!.getFilteredCharacters()
            emit(filteredCharacters)
        } catch (e: Exception) {
            Log.d("error", e.toString())
        }
    }

}