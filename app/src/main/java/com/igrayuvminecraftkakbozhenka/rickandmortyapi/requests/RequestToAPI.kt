package com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests

import android.util.Log
import android.widget.Toast
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RequestToAPI {


    private var service: RickAndMortyService? = null

    fun getCharacter() {
        var character: Character? = null


        val call = service?.listRepos()
        call?.enqueue(object : Callback<InfoData?> {
            override fun onResponse(call: Call<InfoData?>, response: Response<InfoData?>) {
                val name = response.body()?.results?.get(0)?.name
                val status = response.body()?.results?.get(0)?.status
                val species = response.body()?.results?.get(0)?.species
                val gender = response.body()?.results?.get(0)?.gender
                val image = response.body()?.results?.get(0)?.image
                character = Character(name!!, status!!, species!!, gender!!, image!!)
                Log.d("Rick", character!!.name)
            }

            override fun onFailure(call: Call<InfoData?>, t: Throwable) {

            }

        })
    }

    fun init() {
        val builder: OkHttpClient.Builder = OkHttpClient().newBuilder()

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        builder.addInterceptor(interceptor)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(builder.build())
            .build()
        service = retrofit.create(RickAndMortyService::class.java)
    }
}

//call.enqueue(object : Callback<Result> {
//
//    override fun onResponse(call: Call<MainFragment.Response>, response: retrofit2.Response<MainFragment.Response>) {
//        response.body().
//
//
//        Log.d("TestRequest", "response $post")
//    }
//
//    override fun onFailure(call: Call<MainFragment.Response>, t: Throwable) {
//
//    }
//})