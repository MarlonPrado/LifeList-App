package com.example.jetpackcompose.views

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcompose.R
import com.example.jetpackcompose.models.Task
import com.example.jetpackcompose.viewmodels.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskFinishedScreen() {
    val taskViewModel: TaskViewModel = viewModel()
    val tasks by taskViewModel.tasks.collectAsState()
    val isLoading by taskViewModel.isLoading.collectAsState()
    val errorMessage by taskViewModel.errorMessage.collectAsState()

    val context = LocalContext.current

    // Fetch tasks on screen load
    LaunchedEffect(Unit) {
        taskViewModel.fetchTasks(context)
           Log.d("TaskFinishedScreen", "AL FINNNNNNNNNN")
    }

    // Mostrar el Toast cuando se obtengan las tareas
    LaunchedEffect(tasks) {
        if (tasks.isNotEmpty()) {
               Toast.makeText(context, "Tareas Completas cargadas exitosamente", Toast.LENGTH_LONG).show()
            Log.d("TaskFinishedScreen", "Tasks loaded successfully")
        }
    }

    Scaffold(
        topBar = {
            WoofTopAppBar(title = "Finished Tasks")
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                Log.d("TaskFinishedScreen", "Loading tasks")
            } else if (errorMessage != null) {
                Text(errorMessage!!, color = MaterialTheme.colorScheme.error)
                  Log.e("TaskFinishedScreen", "Error: $errorMessage")
               } else {
                val completedTasks = tasks.filter { it.completed }
                LazyColumn {
                       items(completedTasks) { task ->
                        TaskFinishedItem(task, taskViewModel, context)
                        Log.d("TaskFinishedScreen", "Displaying task: ${task.name}")
                          }
                }
            }
        }
    }
}

@Composable
fun TaskFinishedItem(task: Task, taskViewModel: TaskViewModel, context: Context, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(dimensionResource(R.dimen.padding_small))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = task.name, style = MaterialTheme.typography.titleMedium)
                Text(text = task.description, style = MaterialTheme.typography.bodyMedium)
                Text(text = "Priority: ${task.priority}", style = MaterialTheme.typography.bodySmall)
            }
            Button(onClick = { taskViewModel.updateTaskStatus(context, task.id, !task.completed)
                Log.d("TaskFinishedItem", "Updating task status for ${task.name}")
            }) {
                Text(text = if (task.completed) "Mark as Incompletada" else "Mark as Done")
                Log.e("estado", task.completed.toString())
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier, title: String = "Finished Tasks") {
         CenterAlignedTopAppBar(
        title = { Text(text = title) },
        modifier = modifier
    )
}
