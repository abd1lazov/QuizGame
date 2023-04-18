package com.example.quizgame.domain.useCases.history

import com.example.quizgame.domain.entities.HistoryEntity
import com.example.quizgame.domain.repositories.history.DeleteHistoryRepository
import javax.inject.Inject

class DeleteHistoryUseCase @Inject constructor(private val repository: DeleteHistoryRepository){

    suspend fun deleteHistory(historyEntity: HistoryEntity){
        repository.deleteHistory(historyEntity)
    }

}