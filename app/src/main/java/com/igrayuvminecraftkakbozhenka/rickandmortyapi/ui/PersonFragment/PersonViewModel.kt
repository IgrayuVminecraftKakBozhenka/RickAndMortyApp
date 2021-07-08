package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.PersonFragment

import androidx.lifecycle.ViewModel
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.CustomRecyclerAdapter.CustomRecyclerAdapter
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests.RequestToAPI


class PersonViewModel: ViewModel() {

    fun getNewCharacter() {
        RequestToAPI.getCharacter()
    }

}