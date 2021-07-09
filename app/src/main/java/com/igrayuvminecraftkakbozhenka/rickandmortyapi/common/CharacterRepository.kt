package com.igrayuvminecraftkakbozhenka.rickandmortyapi.common

import androidx.lifecycle.MutableLiveData

class CharacterRepository() {
    companion object {
        val CharacterList = MutableLiveData<ArrayList<Character>>()
    }
}