package com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests

import com.google.gson.annotations.SerializedName

class InfoData {
    @SerializedName("results")
    var results: ArrayList<Result> = ArrayList()
}

class Result {

    @SerializedName("name")
    val name = ""

    @SerializedName("status")
    val status = ""

    @SerializedName("species")
    val species = ""

    @SerializedName("gender")
    val gender = ""

    @SerializedName("image")
    val image = ""
}