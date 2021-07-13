package com.igrayuvminecraftkakbozhenka.rickandmortyapi.common

import com.google.gson.JsonObject
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests.RequestToAPI
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests.RickAndMortyService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterRepository private constructor(){

    private val retrofit: RickAndMortyService
    private val allCharacters = ArrayList<Character>()

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

    suspend fun setData(character: Character) {
        retrofit.getCharacters().results

    }

    suspend fun getAllCharacters(): ArrayList<Character> {
        withContext(Dispatchers.IO) {
            RequestToAPI.getCharacter()
        }
        return allCharacters

    }

    fun clearRepository() {
        allCharacters.clear()
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
            .build().create(RickAndMortyService::class.java)
    }

}