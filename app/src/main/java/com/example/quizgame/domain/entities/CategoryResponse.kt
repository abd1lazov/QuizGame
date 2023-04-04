package com.example.quizgame.domain.entities

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("trivia_categories")
    val category: List<CategoryEntity>
)

data class CategoryEntity(
    val name: String,
    val id: Int
) {
    override fun toString(): String {
        return super.toString()
    }
}
