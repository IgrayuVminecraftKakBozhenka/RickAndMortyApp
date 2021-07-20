package com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain

import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.models.Filter
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.models.Character

interface DataRepositoryInterface {

    suspend fun getOnceCharacter(id: Int): Character

    suspend fun getPageWithCharacters(pageId: Int): ArrayList<Character>

    suspend fun getFilteredCharacters(filter: Filter?): ArrayList<Character>

    fun getGenders(): List<Int>

    fun getStatuses(): List<Int>

    fun getSpecies(): List<Int>

    fun getMeFilterIfExist(): Filter?

    fun clearRepository()

}