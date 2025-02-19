package com.radhey.todoapp.domain.repository

import com.radhey.todoapp.data.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTask(): Flow<List<Task>>
    suspend fun addTask(task: Task)
}