package com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.api

import com.google.gson.annotations.SerializedName

class CharacterPage(
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("image")
    val image: String
)