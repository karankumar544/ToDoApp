package com.radhey.todoapp.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM Task ORDER BY date")
    fun getTasks(): Flow<List<Task>>

    @Upsert
    suspend fun addTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)


}