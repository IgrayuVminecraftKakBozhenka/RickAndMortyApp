package com.igrayuvminecraftkakbozhenka.rickandmortyapi.data

import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.api.RequestsToAPI
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.filtres.Filter
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.models.Character
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.interfaces.CharacterRepositoryInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataRepository private constructor() : CharacterRepositoryInterface {

    var filter: Filter? = null

    private val retrofit: RequestsToAPI
    private val charactersCache = ArrayList<Character>()

    companion object {

        private var instance: DataRepository? = null

        private fun createInstance() {
            if (instance == null) {
                instance = DataRepository()
            }
        }

        fun getInstance(): DataRepository? {
            if (instance == null) {
                createInstance()
            }
            return instance
        }

    }

    override suspend fun getOnceCharacter(id: Int): Character {
        val result = retrofit.getOnceCharacter(id)
        return Character(result.name, result.status, result.species, result.gender, result.image)
    }

    override suspend fun getPageWithCharacters(pageId: Int): ArrayList<Character> {
        val characters = retrofit.getPageWithCharacters(pageId).results
        characters.forEach { result ->
            val character =
                Character(result.name, result.status, result.species, result.gender, result.image)
            charactersCache.add(character)
        }
        return charactersCache
    }

    override suspend fun getFilteredCharacters(filter: Filter?): ArrayList<Character> {
        val characters = retrofit.getFilteredCharacters(filter?.name,
            filter?.status,
            filter?.species,
            filter?.type,
            filter?.gender).results
        characters.forEach { result ->
            val character =
                Character(result.name, result.status, result.species, result.gender, result.image)
            charactersCache.add(character)
        }
        return charactersCache
    }

    override fun getMeFilterIfExist(): Filter? {
        if (filter != null) {
            return filter
        }
        return null
    }

    override fun clearRepository() {
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