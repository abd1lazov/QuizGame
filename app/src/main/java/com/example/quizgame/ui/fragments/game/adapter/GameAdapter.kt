package com.example.quizgame.ui.fragments.game.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quizgame.R
import com.example.quizgame.databinding.FragmentGameBinding
import com.example.quizgame.databinding.ItemBooleanBinding
import com.example.quizgame.domain.entities.GameEntity
class GameAdapter:
    ListAdapter<GameEntity, RecyclerView.ViewHolder>(GameItemCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == R.layout.fragment_game) {
            MultipleViewHolder(
                FragmentGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        } else {
            BooleanViewHolder(
                ItemBooleanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val quiz = getItem(position)
        if (holder.itemViewType == R.layout.fragment_game) {
            holder as MultipleViewHolder
            holder.onBind(quiz)
        } else {
                holder as BooleanViewHolder
                holder.onBind(quiz)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val quiz = getItem(position)
        return if(quiz.type == "multiple"){
            R.layout.fragment_game
        }else{
            R.layout.item_boolean
        }
    }
    inner class MultipleViewHolder(private val binding: FragmentGameBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(game: GameEntity) {
            val listGame = mutableListOf<String>()
            listGame.add(game.correctAnswer)
            game.inCorrectAnswer.let {
                it.forEach { incorrect ->
                    listGame.add(incorrect.toString())
                }
            }
            listGame.shuffle()

            val count = "${absoluteAdapterPosition + 1}/${currentList.size}"
            binding.tvProgress.text = count
        }

    }
    inner class BooleanViewHolder(private val binding: ItemBooleanBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(quiz: GameEntity) {
            val listQuiz = mutableListOf<String>()
            listQuiz.add(quiz.correctAnswer)
            quiz.inCorrectAnswer.let {
                it.forEach { incorrect ->
                    listQuiz.add(incorrect.toString())
                }
            }
            listQuiz.shuffle()
        }
    }
}



