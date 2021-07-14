package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.filters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R

class FiltersFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter_settings, container, false)
    }


}