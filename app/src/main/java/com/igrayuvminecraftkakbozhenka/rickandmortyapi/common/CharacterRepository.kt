package com.igrayuvminecraftkakbozhenka.rickandmortyapi.common

import com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests.RequestToAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterRepository() {
    companion object {

        private val allCharacters = ArrayList<Character>()

        fun setData(character: Character) {
            allCharacters.add(character)
        }

        suspend fun getAllCharacters(): ArrayList<Character> {
            withContext(Dispatchers.IO) {
                RequestToAPI.getCharacter()
            }
            return withContext(Dispatchers.Main) {
                allCharacters
            }
        }

        fun clearRepository() {
            allCharacters.clear()
        }
    }

}