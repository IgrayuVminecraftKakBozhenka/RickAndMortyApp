package com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests

import com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.main.MainFragment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {
    @GET("character")
    suspend fun getCharacters(): InfoData

    @GET("character/{id}")
    suspend fun getOnceCharacter(@Path ("id") id: Int)

    @GET("character/?page={pageId}")
    suspend fun getPageWithCharacters(@Path ("pageId") pageId: Int )

    @GET("character/?{filterOne}={parameterOne}{ampersantOne}" +
            "{filterTwo}={parameterTwo}{ampersantTwo}" +
            "{filterThree}={parameterThree}{ampersantThree}" +
            "{filterFour}={parameterFour}{ampersantFour}" +
            "{filterFive}={parameterFive}{ampersantFive}")
    suspend fun getFilteredCharacters(@Path ("filterOne") filterOne: String, @Path("parameterOne") parameterOne: String, @Path("ampersantOne") ampersantOne: Char?,
                                      @Path ("filterTwo") filterTwo: String?, @Path("parameterTwo") parameterTwo: String?, @Path("ampersantTwo") ampersantTwo: Char?,
                                      @Path ("filterThree") filterThree: String?, @Path("parameterThree") parameterThree: String?, @Path("ampersantThree") ampersantThree: Char?,
                                      @Path ("filterFour") filterFour: String?, @Path("parameterFour") parameterFour: String?, @Path("ampersantFour") ampersantFour: Char?,
                                      @Path ("filterFive") filterFive: String?, @Path("parameterFive") parameterFive: String?, @Path("ampersantFive") ampersantFive: Char?)
}
