package com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.api

import com.google.gson.annotations.SerializedName

class PageWithCharacters {
    @SerializedName("results")
    val results: ArrayList<CharacterPage> = ArrayList()
}

