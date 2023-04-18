package com.example.quizgame.ui.fragments.game.adapter

import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quizgame.domain.entities.GameEntity

class GameAdapter:
    ListAdapter<GameEntity, RecyclerView.ViewHolder>(GameItemCallBack()) {

}