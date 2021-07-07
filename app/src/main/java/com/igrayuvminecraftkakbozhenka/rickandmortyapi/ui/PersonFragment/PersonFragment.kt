package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.PersonFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.requests.RequestToAPI
import com.squareup.picasso.Picasso

class PersonFragment : Fragment() {

    private lateinit var viewModel: PersonViewModel
    private lateinit var image: ImageView
    private lateinit var description: TextView

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

        initViews()

        RequestToAPI.character.observe(viewLifecycleOwner, { character ->
            description.text = viewModel.getCorrectData(character)
            Picasso.get().load(viewModel.getImage(character)).into(image)
        })
    }

    private fun initViews() {
        image = requireView().findViewById(R.id.person_image)
        description = requireView().findViewById(R.id.description)
    }
}