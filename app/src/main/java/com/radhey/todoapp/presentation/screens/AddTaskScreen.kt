package com.radhey.todoapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(navHostController: NavHostController) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = { Text(text = "Add Task") },
                navigationIcon = {

                },
                actions = {
                    Icon(imageVector = Icons.AutoMirrored.Filled.Sort, contentDescription = null)
                    Icon(imageVector = Icons.AutoMirrored.Filled.Sort, contentDescription = null)
                }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier.padding(innerPadding)
                .padding(horizontal = 8.dp)
                .background(color = Color.Red)
        ) {

            item {
                Button(modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        navHostController.navigate(route = "taskScreen")
                    }) {
                    Text(text = "Move Next")
                }
            }

        }

    }
}