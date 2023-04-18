package com.example.quizgame.domain.repositories.history

import com.example.quizgame.domain.entities.HistoryEntity
import kotlinx.coroutines.flow.Flow

interface GetHistoryRepository {

    suspend fun getHistory(): Flow<List<HistoryEntity>>
}