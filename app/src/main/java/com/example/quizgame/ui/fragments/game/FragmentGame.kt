package com.example.quizgame.ui.fragments.game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizgame.R
import com.example.quizgame.databinding.FragmentGameBinding
import com.example.quizgame.ui.fragments.game.adapter.GameAdapter

class FragmentGame : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private lateinit var adapter: GameAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(inflater,container,false)

        initViews()
        initListeners()

        return binding.root
    }

    private fun initListeners() {
        binding.icBack.setOnClickListener{
            findNavController().navigate(R.id.navigation_home)
        }
    }
    private fun initViews() {

    }
}