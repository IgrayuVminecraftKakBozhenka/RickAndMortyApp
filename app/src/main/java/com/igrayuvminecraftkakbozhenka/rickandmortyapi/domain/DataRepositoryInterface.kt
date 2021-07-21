package com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain

import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.DataRepository
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.models.Filter
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.models.Character

interface DataRepositoryInterface {

    suspend fun getOnceCharacter(id: Int): Character

    suspend fun getPageWithCharacters(pageId: Int): ArrayList<Character>

    suspend fun getFilteredCharacters(filter: Filter?): ArrayList<Character>

    fun getGenders(): List<DataRepository.GenderValue>

    fun getStatuses(): List<DataRepository.StatusValue>

    fun getSpecies(): List<DataRepository.SpeciesValue>

    fun getMeFilterIfExist(): Filter?

    fun clearRepository()

}