package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R


class MenuFragment : Fragment() {

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(MenuViewModel::class.java)

        val shwifty = view.findViewById<Button>(R.id.get_twenty_characters_button)

        shwifty.setOnClickListener {
            viewModel.goToPerson()
        }

        val filterButton = view.findViewById<Button>(R.id.get_filtered_characters_button)
        filterButton.setOnClickListener {
            viewModel.goToFilter()
        }
    }
}
