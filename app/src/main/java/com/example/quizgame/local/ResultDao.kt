package com.example.quizgame.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.quizgame.local.model.RoomResult

@Dao
interface ResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(roomResult: RoomResult): Long

    @Query("SELECT * FROM questions")
    fun getAllResults(): LiveData<List<RoomResult>>

    @Delete
    suspend fun deleteResult(roomResult: RoomResult)
}