package com.example.quizgame.domain.repositories.game

import com.example.quizgame.common.resource.Resource
import com.example.quizgame.domain.entities.CategoryEntity
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    fun getCategory(): Flow<Resource<List<CategoryEntity>>>

}