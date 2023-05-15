package com.example.quizgame.ui.fragments.home

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.quizgame.R
import com.example.quizgame.common.base.BaseFragment
import com.example.quizgame.common.extensions.setDropSpinner
import com.example.quizgame.databinding.FragmentHomeBinding
import com.example.quizgame.domain.entities.CategoryEntity
import com.google.android.material.slider.Slider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(), AdapterView.OnItemSelectedListener {

    private var category: Int = 0
    private var amount: Int = 0
    private var difficulty: String = ""
    private val bundle = Bundle()

    override fun bind(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }
    override fun setupListeners() {

        binding.slider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {}
            override fun onStopTrackingTouch(slider: Slider) {
                amount = slider.value.toInt()
                bundle.putInt("amo", amount)

            }
        })

        binding.btnStart.setOnClickListener {
            val amount = binding.tvAmount.text.toString().toInt()
            val category = binding.spinner.selectedItem as CategoryEntity
            val difficulty = binding.spinnerDifficulty.selectedItem
            val categoryName = binding.spinner.selectedItem
        }
    }
    override fun setupObservers() {
        TODO("Not yet implemented")
    }

    override fun setupUI() {
        val list = arrayListOf("any difficulty", "easy", "medium", "hard")
        binding.spinnerDifficulty.adapter = setDropSpinner(list)    }

    private fun initViews() {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.category,
            android.R.layout.simple_spinner_item
        )
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinner.adapter = adapter
                binding.spinner.onItemSelectedListener = this
            }
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.difficulty,
            android.R.layout.simple_spinner_item
        )
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinnerDifficulty.adapter = adapter
                binding.spinnerDifficulty.onItemSelectedListener = this
            }

    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        if (parent?.id == R.id.spinner) {
            when (position) {
                0 -> category = 0
                1 -> category = 17
                2 -> category = 18
                3 -> category = 19
                4 -> category = 20
                5 -> category = 21
                6 -> category = 22
                7 -> category = 23
                8 -> category = 24
                9 -> category = 25
                10 -> category = 26
                11 -> category = 27
            }
            bundle.putInt("int", category)
        } else if (parent?.id == R.id.spinnerDifficulty) {
            difficulty = binding.spinnerDifficulty.selectedItem.toString()
            bundle.putString("str", difficulty)
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}