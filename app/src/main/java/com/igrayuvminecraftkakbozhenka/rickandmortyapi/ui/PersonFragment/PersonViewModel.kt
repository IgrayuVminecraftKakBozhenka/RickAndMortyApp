package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.PersonFragment

import androidx.lifecycle.ViewModel
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character


class PersonViewModel: ViewModel() {

    fun getCorrectData(character: Character)  = "Name: " + character.name + "\n" +
                "Gender: " + character.gender + "\n" +
                "Status: " + character.status + "\n" +
                "Species: " + character.species + "\n"

    fun getImage(character: Character) = character.image

}