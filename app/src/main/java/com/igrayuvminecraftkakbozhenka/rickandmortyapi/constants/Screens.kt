package com.igrayuvminecraftkakbozhenka.rickandmortyapi.constants

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.PersonFragment.PersonFragment
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.main.MainFragment

object Screens {

    fun Main() = FragmentScreen {
        MainFragment()
    }

    fun Person() = FragmentScreen {
        PersonFragment()
    }
}