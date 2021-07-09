package com.igrayuvminecraftkakbozhenka.rickandmortyapi.common

import androidx.lifecycle.MutableLiveData

class CharacterRepository() {
    companion object {

        private val newCharacters = ArrayList<Character>()
        val CharacterList = MutableLiveData<ArrayList<Character>>()

        fun setData(character: Character) {
            newCharacters.add(character)
            CharacterList.value = newCharacters
        }
    }
}