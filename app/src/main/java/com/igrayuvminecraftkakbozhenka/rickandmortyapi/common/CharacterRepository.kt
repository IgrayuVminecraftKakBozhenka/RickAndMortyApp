package com.igrayuvminecraftkakbozhenka.rickandmortyapi.common

import androidx.lifecycle.MutableLiveData
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests.RequestToAPI

class CharacterRepository() {
    companion object {

        private val allCharacters = ArrayList<Character>()

        fun setData(character: Character) {
            allCharacters.add(character)
        }

        fun getCharacterFromAPI() {
            RequestToAPI.getCharacter()
        }

        fun getAllCharacters(): ArrayList<Character> = allCharacters

    }
}