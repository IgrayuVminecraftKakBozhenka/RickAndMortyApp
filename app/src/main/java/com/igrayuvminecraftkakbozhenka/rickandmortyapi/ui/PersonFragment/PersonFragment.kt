package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.PersonFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.person_adapter.PersonAdapter
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class PersonFragment : Fragment(), View.OnClickListener, PersonAdapter.PersonListener {

    private lateinit var viewModel: PersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(PersonViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        val adapter = PersonAdapter(this)
        viewPager.adapter = adapter

        val dotsIndicator = view.findViewById<SpringDotsIndicator>(R.id.dots_indicator)
        dotsIndicator.setViewPager2(viewPager)

        viewModel.characterCache.observe(viewLifecycleOwner, { characters ->
            adapter.setDataList(characters)
        })

        viewModel.onceCharacter.observe(viewLifecycleOwner, { character ->
            adapter.setOneCharacter(character)
        })

        val getNewCharacterButton = view.findViewById<Button>(R.id.get_character_button)
        getNewCharacterButton.setOnClickListener(this)


    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clearCache()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.get_character_button -> viewModel.getPageWithCharacters()
        }

    }

    override fun getOnceRandomCharacter() {
        viewModel.getNewRandomCharacter()
    }

}