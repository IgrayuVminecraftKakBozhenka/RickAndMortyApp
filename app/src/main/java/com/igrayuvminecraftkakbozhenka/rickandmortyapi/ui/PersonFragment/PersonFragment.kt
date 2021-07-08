package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.PersonFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.CustomRecyclerAdapter.CustomRecyclerAdapter
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.CharacterRepository
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests.RequestToAPI
import com.squareup.picasso.Picasso
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class PersonFragment : Fragment() {

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
        viewPager.adapter = CustomRecyclerAdapter(CharacterRepository.CharacterList)

        val dotsIndicator = view.findViewById<SpringDotsIndicator>(R.id.dots_indicator)
        dotsIndicator.setViewPager2(viewPager)

        val getNewCharacterButton = view.findViewById<Button>(R.id.get_character_button)
        getNewCharacterButton.setOnClickListener {
            viewModel.getNewCharacter()
            (viewPager.adapter as CustomRecyclerAdapter).notifyDataSetChanged()
        }

    }
}