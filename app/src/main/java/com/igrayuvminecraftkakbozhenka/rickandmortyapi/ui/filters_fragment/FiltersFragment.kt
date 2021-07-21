package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.filters_fragment

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.data.DataRepository

class FiltersFragment: Fragment(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private lateinit var viewModel: FilterViewModel

    private lateinit var nameInput: EditText
    private lateinit var speciesRadioGroup: RadioGroup
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var statusRadioGroup: RadioGroup
    private lateinit var setupButton: Button

    //private var filter = Filter()

    private val repository = DataRepository.getInstance()

    private val species = repository?.getSpecies()
    private val genders = repository?.getGenders()
    private val status = repository?.getStatuses()

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
        observeLiveData()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (nameInput.text != null) {
            viewModel.setName(nameInput.text.toString())
        }
    }


    private fun init() {

        viewModel = ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
            .create(FilterViewModel::class.java)

        nameInput = requireView().findViewById(R.id.input_name)

        speciesRadioGroup = requireView().findViewById(R.id.species_radio_group)
        species?.forEach { value ->
            val radioButton = RadioButton(requireContext())
            radioButton.setText(value.resId)
            radioButton.id = value.id
            speciesRadioGroup.addView(radioButton)
        }
        speciesRadioGroup.setOnCheckedChangeListener(this)

        genderRadioGroup = requireView().findViewById(R.id.gender_radio_group)
        genders?.forEach { value ->
            val radioButton = RadioButton(requireContext())
            radioButton.setText(value.resId)
            radioButton.id = value.id
            genderRadioGroup.addView(radioButton)
        }
        genderRadioGroup.setOnCheckedChangeListener(this)

        statusRadioGroup = requireView().findViewById(R.id.status_radio_group)
        status?.forEach { value ->
            val radioButton = RadioButton(requireContext())
            radioButton.setText(value.resId)
            radioButton.id = value.id
            statusRadioGroup.addView(radioButton)
        }
        statusRadioGroup.setOnCheckedChangeListener(this)


        setupButton = requireView().findViewById(R.id.setup_filters_button)
        setupButton.setOnClickListener(this)
    }

    private fun observeLiveData() {
        viewModel.name.observe(viewLifecycleOwner, {value ->
            nameInput.text = Editable.Factory.getInstance().newEditable(value)
        })

        viewModel.species.observe(viewLifecycleOwner, { value ->
            speciesRadioGroup.check(value.id)
        })

        viewModel.gender.observe(viewLifecycleOwner, { value ->
            genderRadioGroup.check(value.id)
        })

        viewModel.status.observe(viewLifecycleOwner, {value ->
            statusRadioGroup.check(value.id)
        })
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.setup_filters_button -> {
                if (nameInput.text != null) {
                    viewModel.setName(nameInput.text.toString())
                }

                viewModel.goToPerson()
            }
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        Log.d("checked_id", checkedId.toString())
        species?.forEach { value ->
            Log.d("checked_id", checkedId.toString())
            if( value.id == checkedId && value.value != DataRepository.SpeciesValue.NOT_SELECTED.value) {
                viewModel.setSpecies(value)
            }

        }

        genders?.forEach { value ->
            if( value.id == checkedId && value.value != DataRepository.GenderValue.NOT_SELECTED.value) {
                viewModel.setGender(value)
            }
        }

        status?.forEach { value ->
            if( value.id == checkedId && value.value != DataRepository.StatusValue.NOT_SELECTED.value) {
                viewModel.setStatus(value)
            }
        }

    }
}