package com.radhey.todoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.radhey.todoapp.data.model.Task
import com.radhey.todoapp.data.model.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskDao: TaskDao,
) : ViewModel() {

    private val _allTask: MutableStateFlow<List<Task>> = MutableStateFlow(emptyList())
    private val allTask: StateFlow<List<Task>> = _allTask.asStateFlow()

    init {
        viewModelScope.launch {
            taskDao.getTasks().collectLatest {
                _allTask.value = it
            }
        }
    }

    fun addTask(task: Task) {
        viewModelScope.launch {
            taskDao.addTask(task)
        }
    }

}