package com.radhey.todoapp.data.repository

import com.radhey.todoapp.data.model.Task
import com.radhey.todoapp.data.model.TaskDao
import com.radhey.todoapp.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepoImplementation(private val taskDao: TaskDao) : TaskRepository {
    override fun getTask(): Flow<List<Task>> = taskDao.getTasks()
    override suspend fun addTask(task: Task) {
        taskDao.addTask(task)
    }

}