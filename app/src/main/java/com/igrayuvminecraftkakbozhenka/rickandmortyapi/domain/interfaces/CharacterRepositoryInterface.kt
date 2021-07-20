package com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.interfaces

import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.filtres.Filter
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.models.Character

interface CharacterRepositoryInterface {

    suspend fun getOnceCharacter(id: Int): Character

    suspend fun getPageWithCharacters(pageId: Int): ArrayList<Character>

    suspend fun getFilteredCharacters(filter: Filter?): ArrayList<Character>

    fun getMeFilterIfExist(): Filter?

    fun clearRepository()

}