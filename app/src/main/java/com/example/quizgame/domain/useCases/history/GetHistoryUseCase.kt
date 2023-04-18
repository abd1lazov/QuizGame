package com.example.quizgame.domain.useCases.history

import com.example.quizgame.domain.repositories.history.GetHistoryRepository
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(private val repository: GetHistoryRepository){

   suspend fun invoke() = repository.getHistory()
}