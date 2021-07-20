package com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain

import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.api.CharacterPage
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.api.PageWithCharacters

interface RequestsToAPIInterface {

    suspend fun getOnceCharacter(id: Int): CharacterPage

    suspend fun getPageWithCharacters(page: Int): PageWithCharacters

    suspend fun getFilteredCharacters(name: String? = null, status: String? = null,
                                       species: String? = null,  type: String? = null, gender: String? = null): PageWithCharacters
}