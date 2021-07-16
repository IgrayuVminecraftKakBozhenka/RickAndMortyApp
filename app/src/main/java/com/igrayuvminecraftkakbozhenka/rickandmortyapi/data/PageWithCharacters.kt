package com.igrayuvminecraftkakbozhenka.rickandmortyapi.data

import com.google.gson.annotations.SerializedName
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.api.CharacterPage

class PageWithCharacters {
    @SerializedName("results")
    var results: ArrayList<CharacterPage> = ArrayList()
}

