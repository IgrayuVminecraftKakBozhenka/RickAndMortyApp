//package com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests
//
//import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
//import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.CharacterRepository
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.net.HttpURLConnection
//
//
//object RequestToAPI {
//
//
//    private var service: RickAndMortyService? = null
//
//    fun getCharacter() {
//
//        val call = service?.listRepos()
//
//        call?.execute()?.body()?.results.size
//        call?.enqueue(object : Callback<InfoData?> {
//            override fun onResponse(call: Call<InfoData?>, response: Response<InfoData?>) {
//                val size = response.body()!!.results.size
//                val index = (1..size).random() - 1
//                val name = response.body()!!.results[index].name
//                val status = response.body()!!.results[index].status
//                val species = response.body()!!.results[index].species
//                val gender = response.body()!!.results[index].gender
//                val image = response.body()!!.results[index].image
//
//                val characterFromAPI = Character(name, status, species, gender, image)
//                CharacterRepository.setData(characterFromAPI)
//            }
//
//            override fun onFailure(call: Call<InfoData?>, t: Throwable) {
//
//            }
//        })
//    }
//
//    fun init() {
//        val builder: OkHttpClient.Builder = OkHttpClient().newBuilder()
//
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//        builder.addInterceptor(interceptor)
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://rickandmortyapi.com/api/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory()
//            .client(builder.build())
//            .build()
//        service = retrofit.create(RickAndMortyService::class.java)
//    }
//}