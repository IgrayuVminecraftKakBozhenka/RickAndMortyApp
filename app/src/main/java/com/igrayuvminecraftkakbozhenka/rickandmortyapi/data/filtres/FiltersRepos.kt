package com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.filtres

import android.util.Log
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.Character
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception


class FiltersRepository() {

    var filter: Filter? = null

    companion object {

        private var instance: FiltersRepository? = null

        private fun createInstance() {
            if (instance == null) {
                instance = FiltersRepository()
            }
        }

        fun getInstance(): FiltersRepository? {
            if (instance == null) {
                createInstance()
            }
            return instance
        }

    }

    fun getMeFiltersIfExist(): Filter? {
        if (filter != null) {
            return filter
        }
        return null
    }

}