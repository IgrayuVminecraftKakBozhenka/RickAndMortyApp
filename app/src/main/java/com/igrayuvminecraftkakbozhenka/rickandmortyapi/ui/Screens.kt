package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.person_fragment.PersonFragment
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.filters_fragment.FiltersFragment
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.menu.MenuFragment

object Screens {

    fun Main() = FragmentScreen {
        MenuFragment()
    }

    fun Person() = FragmentScreen {
        PersonFragment()
    }

    fun Filters() = FragmentScreen {
        FiltersFragment()
    }
}