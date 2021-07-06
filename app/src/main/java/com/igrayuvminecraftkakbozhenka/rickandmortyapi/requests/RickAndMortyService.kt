package com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests

import com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.main.MainFragment
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyService {
    @GET("character")
    fun listRepos(): Call<InfoData>
}