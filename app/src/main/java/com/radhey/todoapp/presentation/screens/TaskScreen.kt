package com.radhey.todoapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(navController: NavHostController) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = { Text("TASKAPP") }, actions = {
            IconButton(onClick = { /* TODO: Sorting Action */ }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.Sort, contentDescription = "Sort")
            }
        })
    }, floatingActionButton = {
        FloatingActionButton(onClick = { navController.navigate("addTaskScreen") }) {
            Icon(imageVector = Icons.Default.AddTask, contentDescription = "Add Task")
        }
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            Text("Pending Tasks", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(8.dp))

            LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(8.dp)) {
                // List of Pending Tasks (Mock UI)
                items(5) { index ->
                    TaskItem("Pending Task $index", "This is a pending task description")
                }

                item {
                    Text(
                        "Completed Tasks",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                // List of Completed Tasks (Mock UI)
                items(3) { index ->
                    TaskItem("Completed Task $index", "This is a completed task description", true)
                }
            }
        }
    }
}

@Composable
fun TaskItem(title: String, description: String, isCompleted: Boolean = false) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp), elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(title, style = MaterialTheme.typography.titleMedium)
                Text(description, style = MaterialTheme.typography.bodySmall)
            }
            Checkbox(checked = isCompleted, onCheckedChange = { /* Handle UI Checkbox */ })
        }
    }
}
