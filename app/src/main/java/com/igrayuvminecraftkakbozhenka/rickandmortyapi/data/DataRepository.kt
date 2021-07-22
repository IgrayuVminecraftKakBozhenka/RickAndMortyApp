package com.igrayuvminecraftkakbozhenka.rickandmortyapi.data

import android.util.Log
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.api.RequestsToAPI
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.DataRepositoryInterface
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.models.Filter
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.models.Character
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataRepository private constructor() : DataRepositoryInterface {

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

    override suspend fun getFilteredCharacters(filter: Filter?): ArrayList<Character>? {
        Log.d("filter", filter.toString())
        try {
            val characters = retrofit.getFilteredCharacters(filter?.name,
                filter?.status,
                filter?.species,
                filter?.gender).results
            characters.forEach { result ->
                val character =
                    Character(result.name, result.status, result.species, result.gender, result.image)
                charactersCache.add(character)
            }
        } catch (e: Exception) {
            return null
        }

        return charactersCache
    }

    override fun getGenders(): List<GenderValue> = listOf(GenderValue.MALE, GenderValue.FEMALE, GenderValue.UNKNOWN, GenderValue.NOT_SELECTED)

    override fun getStatuses(): List<StatusValue> = listOf(StatusValue.ALIVE, StatusValue.DEAD, StatusValue.UNKNOWN, StatusValue.NOT_SELECTED)

    override fun getSpecies(): List<SpeciesValue> = listOf(SpeciesValue.ALIEN, SpeciesValue.ANIMAL,
        SpeciesValue.HUMAN, SpeciesValue.HUMANOID, SpeciesValue.MYTHOLOGICAL_CREATURE, SpeciesValue.ROBOT, SpeciesValue.POOPYBUTTHOLE, SpeciesValue.UNKNOWN, SpeciesValue.NOT_SELECTED)


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

    enum class GenderValue(val resId: Int, val id: Int, val value: String) {
        MALE(R.string.male, 1, "male"),
        FEMALE(R.string.female, 2, "female"),

        UNKNOWN(R.string.unknown, 3, "unknown"),
        NOT_SELECTED(R.string.not_selected, 4, "not selected")
    }

    enum class StatusValue(val resId: Int, val id: Int, val value: String) {
        ALIVE(R.string.alive, 5, "alive"),
        DEAD(R.string.dead, 6, "dead"),

        UNKNOWN(R.string.unknown, 7, "unknown"),
        NOT_SELECTED(R.string.not_selected, 8, "not selected")
    }

    enum class SpeciesValue(val resId: Int, val id: Int, val value: String) {
        ALIEN(R.string.alien, 9, "alien"),
        ANIMAL(R.string.animal, 10, "animal"),
        HUMAN(R.string.human, 11, "human"),
        HUMANOID(R.string.human, 12, "humanoid"),
        MYTHOLOGICAL_CREATURE(R.string.mythological_creature, 13, "mythological creature"),
        ROBOT(R.string.robot, 14, "robot"),
        POOPYBUTTHOLE(R.string.poopybutthole, 15, "poopybutthole"),

        UNKNOWN(R.string.unknown, 16, "unknown"),
        NOT_SELECTED(R.string.not_selected, 17, "not selected")
    }

}