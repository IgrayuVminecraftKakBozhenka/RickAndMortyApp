package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.person_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.person_fragment.adapter.PersonAdapter
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

class PersonFragment : Fragment(), View.OnClickListener, PersonAdapter.PersonListener {

    private lateinit var viewModel: PersonViewModel
    private lateinit var adapter: PersonAdapter
    private lateinit var getNewCharacterButton: Button


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
        adapter = PersonAdapter(this)
        viewPager.adapter = adapter

        observeLiveData()
        initComponents()
        viewModel.chekFilters()

        val dotsIndicator = view.findViewById<SpringDotsIndicator>(R.id.dots_indicator)
        dotsIndicator.setViewPager2(viewPager)
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

    private fun observeLiveData() {
        viewModel.characterCache.observe(viewLifecycleOwner, { characters ->
            adapter.setDataList(characters)
        })

        viewModel.onceCharacter.observe(viewLifecycleOwner, { character ->
            adapter.setOneCharacter(character)
        })
    }

    private fun initComponents() {
        getNewCharacterButton = requireView().findViewById(R.id.get_character_button)
        getNewCharacterButton.setOnClickListener(this)
    }

}