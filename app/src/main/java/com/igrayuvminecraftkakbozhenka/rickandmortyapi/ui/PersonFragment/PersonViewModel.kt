package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.PersonFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.CustomRecyclerAdapter.CustomRecyclerAdapter
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.CharacterRepository
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests.RequestToAPI
import kotlinx.coroutines.launch


class PersonViewModel: ViewModel() {

    val characterList = MutableLiveData<ArrayList<Character>>()

    fun getNewCharacter() {
        viewModelScope.launch {
            val characters = CharacterRepository.getAllCharacters()
            characterList.postValue(characters)
        }
    }

}