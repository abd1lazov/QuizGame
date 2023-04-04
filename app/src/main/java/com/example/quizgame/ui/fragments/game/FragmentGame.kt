package com.example.quizgame.ui.fragments.game

import com.example.quizgame.common.base.BaseFragment
import com.example.quizgame.databinding.FragmentGameBinding
import com.example.quizgame.ui.fragments.game.adapter.GameAdapter
class FragmentGame : BaseFragment<FragmentGameBinding>() {

    private var correctAnswer: Int = 0
    private val adapter: GameAdapter by lazy {
        GameAdapter()
    }

    override fun setupData() {
        super.setupData()
    }
    override fun setupListeners() {
        TODO("Not yet implemented")
    }

    override fun setupObservers() {
        TODO("Not yet implemented")
    }

    override fun setupUI() {
        TODO("Not yet implemented")
    }

    override fun bind(): FragmentGameBinding {
        TODO("Not yet implemented")
    }
}
