package com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class InfoData {
    @SerializedName("results")
    var results: ArrayList<Result> = ArrayList()
}

class Result {

    @SerializedName("name")
    var name = ""

    @SerializedName("status")
    var status = ""

    @SerializedName("species")
    var species = ""

    @SerializedName("gender")
    var gender = ""

    @SerializedName("image")
    var image = ""
}