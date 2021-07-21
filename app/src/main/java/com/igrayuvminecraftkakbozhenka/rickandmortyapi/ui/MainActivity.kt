package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.App
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class MainActivity : AppCompatActivity() {

    private val navigator = AppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).router.newRootScreen(Screens.Main())
        Log.d("debug", "${application is App}")

        init()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        (application as App).navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        (application as App).navigatorHolder.removeNavigator()
    }

    private fun init() {
        val builder: OkHttpClient.Builder = OkHttpClient().newBuilder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        builder.addInterceptor(interceptor)
    }
}