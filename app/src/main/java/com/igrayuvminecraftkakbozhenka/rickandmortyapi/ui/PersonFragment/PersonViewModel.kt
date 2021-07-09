package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.PersonFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.CustomRecyclerAdapter.CustomRecyclerAdapter
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.CharacterRepository
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests.RequestToAPI


class PersonViewModel: ViewModel() {

    val characterList = MutableLiveData<ArrayList<Character>>()

    fun getNewCharacter() {
        CharacterRepository.getCharacterFromAPI()
        characterList.value = CharacterRepository.getAllCharacters()
    }

}