package com.example.quizgame.domain.repositories.history

import com.example.quizgame.domain.entities.HistoryEntity

interface AddHistoryRepository {

    suspend fun addHistory(historyEntity: HistoryEntity)
}