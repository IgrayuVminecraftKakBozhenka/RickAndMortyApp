package com.igrayuvminecraftkakbozhenka.rickandmortyapi.common

import com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests.RequestsToAPI
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.filtres.Parameters
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterRepository private constructor() {

    private val retrofit: RequestsToAPI
    private val charactersCache = ArrayList<Character>()

    companion object {

        private var instance: CharacterRepository? = null

        private fun createInstance() {
            if (instance == null) {
                instance = CharacterRepository()
            }
        }

        fun getInstance(): CharacterRepository? {
            if (instance == null) {
                createInstance()
            }
            return instance
        }

    }

    suspend fun getOnceCharacter(id: Int): Character {
        val result = retrofit.getOnceCharacter(id)
        return Character(result.name, result.status, result.species, result.gender, result.image)
    }

    suspend fun getPageWithCharacters(pageId: Int): ArrayList<Character> {
        val characters = retrofit.getPageWithCharacters(pageId).results
        characters.forEach { result ->
            val character =
                Character(result.name, result.status, result.species, result.gender, result.image)
            charactersCache.add(character)
        }
        return charactersCache
    }

    suspend fun getFilteredCharacters(): ArrayList<Character> {
        val characters = retrofit.getFilteredCharacters(Parameters.name, Parameters.status, Parameters.species, Parameters.type, Parameters.gender).results
        characters.forEach { result ->
            val character =
                Character(result.name, result.status, result.species, result.gender, result.image)
            charactersCache.add(character)
        }
        return charactersCache
    }

    fun clearRepository() {
        charactersCache.clear()
    }

    init {
        val builder: OkHttpClient.Builder = OkHttpClient().newBuilder()

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        builder.addInterceptor(interceptor)

        retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(builder.build())
            .build().create(RequestsToAPI::class.java)
    }

}