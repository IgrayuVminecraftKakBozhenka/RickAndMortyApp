package com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface RickAndMortyService {
    @GET("character")
    suspend fun getCharacters(): InfoData

    @GET("character/{id}")
    suspend fun getOnceCharacter(@Path ("id") id: Int): Result

    @GET("character/")
    suspend fun getPageWithCharacters(@Query ("page") page: Int ): InfoData

    @GET("character/?{filterOne}={parameterOne}{ampersantOne}" +
            "{filterTwo}={parameterTwo}{ampersantTwo}" +
            "{filterThree}={parameterThree}{ampersantThree}" +
            "{filterFour}={parameterFour}{ampersantFour}" +
            "{filterFive}={parameterFive}{ampersantFive}")
    suspend fun getFilteredCharacters(@Path ("filterOne") filterOne: String, @Path("parameterOne") parameterOne: String, @Path("ampersantOne") ampersantOne: Char?,
                                      @Path ("filterTwo") filterTwo: String?, @Path("parameterTwo") parameterTwo: String?, @Path("ampersantTwo") ampersantTwo: Char?,
                                      @Path ("filterThree") filterThree: String?, @Path("parameterThree") parameterThree: String?, @Path("ampersantThree") ampersantThree: Char?,
                                      @Path ("filterFour") filterFour: String?, @Path("parameterFour") parameterFour: String?, @Path("ampersantFour") ampersantFour: Char?,
                                      @Path ("filterFive") filterFive: String?, @Path("parameterFive") parameterFive: String?, @Path("ampersantFive") ampersantFive: Char?): InfoData
}
