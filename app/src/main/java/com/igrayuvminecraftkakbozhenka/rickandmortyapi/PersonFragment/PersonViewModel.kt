package com.igrayuvminecraftkakbozhenka.rickandmortyapi.PersonFragment

import androidx.lifecycle.ViewModel
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests.RequestToAPI


class PersonViewModel: ViewModel() {

    fun getCorrectData(character: Character)  = "Name: " + character.name + "\n" +
                "Gender: " + character.gender + "\n" +
                "Status: " + character.status + "\n" +
                "Species: " + character.species + "\n"

    fun getImage(character: Character) = character.image

}