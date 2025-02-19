package com.radhey.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.radhey.todoapp.presentation.screens.AddTaskScreen
import com.radhey.todoapp.presentation.screens.TaskScreen

@Composable
fun AppNavGraph(navController: NavHostController, startDestination: String) {

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = "taskScreen") {
            TaskScreen(navController = navController)
        }

        composable(route = "addTaskScreen") {
            AddTaskScreen(navHostController = navController)
        }
    }

}