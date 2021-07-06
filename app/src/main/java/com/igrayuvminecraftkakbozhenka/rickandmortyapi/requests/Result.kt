package com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class InfoData {
    @SerializedName("results")
    var results: List<Result> = emptyList()
}

class Result {

    @SerializedName("name")
    @Expose
    var name = ""

    @SerializedName("status")
    @Expose
    var status = ""

    @SerializedName("species")
    @Expose
    var species = ""

    @SerializedName("gender")
    @Expose
    var gender = ""

    @SerializedName("image")
    @Expose
    var image = ""

}