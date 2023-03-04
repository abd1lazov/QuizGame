package com.example.quizgame.ui.fragments.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizgame.R
import com.example.quizgame.databinding.FragmentResultBinding

class FragmentResult : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater,container,false)

        initViews()
        initListeners()

        return binding.root
    }

    private fun initListeners() {
    }

    private fun initViews() {}
}