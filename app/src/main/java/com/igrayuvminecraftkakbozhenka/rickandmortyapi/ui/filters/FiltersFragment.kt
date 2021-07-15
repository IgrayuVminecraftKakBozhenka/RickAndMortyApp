package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.filters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R

class FiltersFragment: Fragment(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {

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
        nameInput = requireView().findViewById(R.id.input_name)
        speciesInput = requireView().findViewById(R.id.input_species)

        genderRadioGroup = requireView().findViewById(R.id.gender_radio_group)
        genderRadioGroup.setOnCheckedChangeListener(this)

        statusRadioGroup = requireView().findViewById(R.id.status_radio_group)
        statusRadioGroup.setOnCheckedChangeListener(this)

        setupButton = requireView().findViewById(R.id.setup_filters_button)
    }

    override fun onClick(v: View?) {

    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.male_radio_button -> TODO()
            R.id.female_radio_button -> TODO()
            R.id.unknown_gender_radio_button -> TODO()

            R.id.alive_radio_button -> TODO()
            R.id.dead_radio_button -> TODO()
            R.id.unknown_status_radio_button -> TODO()
        }
    }
}