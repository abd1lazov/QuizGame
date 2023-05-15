package com.example.quizgame.ui.fragments.game.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.quizgame.domain.entities.GameEntity

class GameItemCallBack: DiffUtil.ItemCallback<GameEntity>() {
    override fun areItemsTheSame(oldItem: GameEntity, newItem: GameEntity) =
        oldItem.question == newItem.question
    override fun areContentsTheSame(oldItem: GameEntity, newItem: GameEntity) = oldItem == newItem

}