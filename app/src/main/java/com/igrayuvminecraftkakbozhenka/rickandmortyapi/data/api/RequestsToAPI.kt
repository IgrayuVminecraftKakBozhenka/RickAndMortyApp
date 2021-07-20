package com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.api

import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.RequestsToAPIInterface
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RequestsToAPI: RequestsToAPIInterface {

    @GET("character/{id}")
    override suspend fun getOnceCharacter(@Path ("id") id: Int): CharacterPage

    @GET("character/")
    override suspend fun getPageWithCharacters(@Query ("page") page: Int ): PageWithCharacters

    @GET("character")
    override suspend fun getFilteredCharacters(@Query ("name") name: String?, @Query ("status") status: String?,
    @Query ("species") species: String?, @Query ("type") type: String?, @Query ("gender") gender: String?): PageWithCharacters
}
