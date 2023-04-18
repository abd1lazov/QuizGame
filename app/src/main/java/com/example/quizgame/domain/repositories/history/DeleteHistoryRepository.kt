package com.example.quizgame.domain.repositories.history

import com.example.quizgame.domain.entities.HistoryEntity

interface DeleteHistoryRepository {

    suspend fun deleteHistory(historyEntity: HistoryEntity)
}