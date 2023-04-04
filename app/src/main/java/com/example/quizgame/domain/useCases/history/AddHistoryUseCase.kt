package com.example.quizgame.domain.useCases.history

import com.example.quizgame.domain.entities.HistoryEntity
import com.example.quizgame.domain.repositories.history.AddHistoryRepository

class AddHistoryUseCase @Inject constructor(private val repository: AddHistoryRepository) {

    suspend fun addHistory(historyEntity: HistoryEntity){
        repository.addHistory(historyEntity)
    }
}