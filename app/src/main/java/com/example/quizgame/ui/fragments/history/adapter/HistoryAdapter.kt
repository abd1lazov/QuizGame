package com.example.quizgame.ui.fragments.history.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizgame.databinding.FragmentHistoryBinding

class HistoryAdapter: RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = FragmentHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}