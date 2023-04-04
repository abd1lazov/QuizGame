package com.example.quizgame.domain.entities

import com.google.gson.annotations.SerializedName

data class GameResponse(
    @SerializedName("response_code")
    val responseCode: Int,
    val result: List<GameEntity>
)

data class GameEntity(
    val category: String,
    @SerializedName("correct_answer")
    val correctAnswer: String,
    val difficulty: String,
    @SerializedName("incorrect_answer")
    val inCorrectAnswer: String,
    val question: String,
    val type: String
)