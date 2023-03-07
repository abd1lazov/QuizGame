package com.example.quizgame.ui.fragments.game.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizgame.databinding.ItemQzRvBinding
import com.example.quizgame.model.QuizResponse

class GameAdapter(private val clickListener: (item: QuizResponse.Result, position: Int, isCorrect: Boolean) -> Unit) :
    RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    private lateinit var binding: ItemQzRvBinding
    private val list: ArrayList<QuizResponse.Result> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameAdapter.ViewHolder {
        binding = ItemQzRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: GameAdapter.ViewHolder, position: Int) {
        holder.onBind(list[position])
        binding.btnSkip.setOnClickListener {
            clickListener(list[position], position, false)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var binding: ItemQzRvBinding

        fun onBind(result: QuizResponse.Result) {

            binding.tvQuestion.text = result.question

            var list: ArrayList<String> = arrayListOf()

            list = result.incorrect_answers
            list.add(result.correct_answer)
            list.shuffle()

            binding.btnFirst.apply {
                text = list[0]
                setOnClickListener {
                    clickListener(result, adapterPosition, text == result.correct_answer)
                }
            }
            binding.btnSecond.apply {
                text = list[1]
                setOnClickListener {
                    clickListener(result, adapterPosition, text == result.correct_answer)
                }

            }
            binding.btnThird.apply {
                text = list[2]
                setOnClickListener {
                    clickListener(result, adapterPosition, text == result.correct_answer)

                }
            }
            binding.btnFourth.apply {
                text = list[3]
                setOnClickListener {
                    clickListener(result, adapterPosition, text == result.correct_answer)

                }
            }
        }
    }
}