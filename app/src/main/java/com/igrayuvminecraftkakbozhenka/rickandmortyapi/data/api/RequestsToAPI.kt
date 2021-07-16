package com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.api

import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.PageWithCharacters
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RequestsToAPI {

    @GET("character/{id}")
    suspend fun getOnceCharacter(@Path ("id") id: Int): CharacterPage

    @GET("character/")
    suspend fun getPageWithCharacters(@Query ("page") page: Int ): PageWithCharacters

    @GET("character")
    suspend fun getFilteredCharacters(@Query ("name") name: String? = null , @Query ("status") status: String? = null,
    @Query ("species") species: String? = null, @Query ("type") type: String? = null, @Query ("gender") gender: String? = null): PageWithCharacters
}
