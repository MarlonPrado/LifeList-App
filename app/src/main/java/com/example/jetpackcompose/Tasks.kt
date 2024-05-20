package com.example.jetpackcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.db.Task
import com.example.jetpackcompose.db.tasks

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen() {

    // Estados para almacenar los valores de entrada del formulario
    val (taskName, setTaskName) = remember { mutableStateOf("") }
    val (taskDate, setTaskDate) = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Create a Task")

        // Campos de entrada para el nombre y la fecha de la tarea
        OutlinedTextField(
            value = taskName,
            onValueChange = setTaskName,
            label = { Text("Task Name") }
        )
        OutlinedTextField(
            value = taskDate,
            onValueChange = setTaskDate,
            label = { Text("Task Date") }
        )

        // Botón para agregar una nueva tarea
        Button(
            onClick = {
                // Crea una nueva tarea con los valores ingresados
                val newTask = Task(tasks.size + 1, taskName, taskDate)
                // Agrega la nueva tarea a la lista
                tasks.add(newTask)
                // Limpia los campos de entrada
                setTaskName("")
                setTaskDate("")
            }
        ) {
            Text("Save Task")
        }

        // Muestra la lista de tareas
        tasks.forEach { task ->
            Text("${task.name} - ${task.date}")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TasksPreview() {
    JetpackComposeTheme(darkTheme = false) {

        // Estados para almacenar los valores de entrada del formulario
        val (taskName, setTaskName) = remember { mutableStateOf("") }
        val (taskDate, setTaskDate) = remember { mutableStateOf("") }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Create a Task")

            // Campos de entrada para el nombre y la fecha de la tarea
            OutlinedTextField(
                value = taskName,
                onValueChange = setTaskName,
                label = { Text("Task Name") }
            )
            OutlinedTextField(
                value = taskDate,
                onValueChange = setTaskDate,
                label = { Text("Task Date") }
            )

            // Botón para agregar una nueva tarea
            Button(
                onClick = {
                    // Crea una nueva tarea con los valores ingresados
                    val newTask = Task(tasks.size + 1, taskName, taskDate)
                    // Agrega la nueva tarea a la lista
                    tasks.add(newTask)
                    // Limpia los campos de entrada
                    setTaskName("")
                    setTaskDate("")
                }
            ) {
                Text("Save Task")
            }

            // Muestra la lista de tareas
            tasks.forEach { task ->
                Text("${task.name} - ${task.date}")
            }
        }
    }
}