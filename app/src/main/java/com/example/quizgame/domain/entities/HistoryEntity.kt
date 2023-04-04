package com.example.quizgame.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryEntity(
    val difficulty: String,
    val category: String,
    val correctAnswers: String,
    val data: String? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)