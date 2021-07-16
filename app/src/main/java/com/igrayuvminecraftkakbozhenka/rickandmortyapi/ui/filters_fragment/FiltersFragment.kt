package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.filters_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.filtres.Parameters

class FiltersFragment: Fragment(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private lateinit var viewModel: FilterViewModel
    private lateinit var nameInput: EditText
    private lateinit var speciesInput: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var statusRadioGroup: RadioGroup
    private lateinit var setupButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        viewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(FilterViewModel::class.java)

        nameInput = requireView().findViewById(R.id.input_name)
        speciesInput = requireView().findViewById(R.id.input_species)

        genderRadioGroup = requireView().findViewById(R.id.gender_radio_group)
        genderRadioGroup.setOnCheckedChangeListener(this)

        statusRadioGroup = requireView().findViewById(R.id.status_radio_group)
        statusRadioGroup.setOnCheckedChangeListener(this)

        setupButton = requireView().findViewById(R.id.setup_filters_button)
        setupButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.setup_filters_button -> {
                Parameters.name = nameInput.text.toString()
                Parameters.species = speciesInput.text.toString()
                viewModel.goToPerson()
            }
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.male_radio_button -> Parameters.gender = "male"
            R.id.female_radio_button -> Parameters.gender = "female"
            R.id.unknown_gender_radio_button -> Parameters.gender = "unknown"
            R.id.genderless_radio_button -> Parameters.gender = "genderless"

            R.id.alive_radio_button -> Parameters.status = "alive"
            R.id.dead_radio_button -> Parameters.status = "dead"
            R.id.unknown_status_radio_button -> Parameters.status = "unknown"
        }
    }
}