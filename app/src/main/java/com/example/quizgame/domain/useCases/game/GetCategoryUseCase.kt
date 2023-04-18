package com.example.quizgame.domain.useCases.game

import com.example.quizgame.domain.repositories.game.GameRepository
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(private val repository: GameRepository) {

    operator fun invoke() = repository.getCategory()

}