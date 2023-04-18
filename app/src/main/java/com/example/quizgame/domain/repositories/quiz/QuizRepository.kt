package com.example.quizgame.domain.repositories.quiz

import com.example.quizgame.common.resource.Resource
import com.example.quizgame.domain.entities.GameEntity
import kotlinx.coroutines.flow.Flow

interface QuizRepository {

    fun getQuiz(
        amount: Int?,
        category: Int?,
        difficulty: String?
    ): Flow<Resource<List<GameEntity>>>

}