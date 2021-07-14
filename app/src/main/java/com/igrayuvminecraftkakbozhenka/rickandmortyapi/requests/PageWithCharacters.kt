package com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests

import com.google.gson.annotations.SerializedName

class PageWithCharacters {
    @SerializedName("results")
    var results: ArrayList<CharacterPage> = ArrayList()
}

