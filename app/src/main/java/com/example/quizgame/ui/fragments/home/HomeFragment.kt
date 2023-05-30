package com.example.quizgame.ui.fragments.home

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import com.example.quizgame.R
import com.example.quizgame.common.base.BaseFragment
import com.example.quizgame.common.extensions.setDropSpinner
import com.example.quizgame.databinding.FragmentHomeBinding
import com.example.quizgame.domain.entities.CategoryEntity
import com.google.android.material.slider.Slider

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by activityViewModels()

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

//        lifecycleScope.launchWhenCreated {
//            viewModel.categoryList_.collectLatest{
//                binding.
//            }
//        }
    }

    override fun setupUI() {
        val list = arrayListOf("any difficulty", "easy", "medium", "hard")
        binding.spinnerDifficulty.adapter = setDropSpinner(list)
        initViews()
    }

    private fun initViews() {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.category,
            android.R.layout.simple_spinner_item
        )
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinner.adapter = adapter
            }
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.difficulty,
            android.R.layout.simple_spinner_item
        )
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spinnerDifficulty.adapter = adapter
            }

    }
}