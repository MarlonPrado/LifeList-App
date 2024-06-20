package com.example.jetpackcompose.views

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.jetpackcompose.viewmodels.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(navController: NavHostController) {
    val taskViewModel: TaskViewModel = viewModel()
    val context = LocalContext.current

    var name by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var priority by remember { mutableStateOf(5) }
    var errorMessage by remember { mutableStateOf("") }

    val priorityColors = listOf(
        Color.Red, Color(0xFFFF4500), Color(0xFFFF8C00), Color(0xFFFFD700),
        Color.Yellow, Color(0xFFADFF2F), Color(0xFF7FFF00), Color(0xFF32CD32),
        Color.Green, Color(0xFF008000)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Create a Task", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Priority", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            priorityColors.forEachIndexed { index, color ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(30.dp)
                        .background(color)
                        .border(
                            width = if (priority == index + 1) 2.dp else 0.dp,
                            color = if (priority == index + 1) Color.Black else Color.Transparent
                        )
                        .clickable { priority = index + 1 }
                ) {
                    Text(text = (index + 1).toString(), color = Color.White)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Button(onClick = {
            if (name.text.isNotEmpty() && description.text.isNotEmpty()) {
                taskViewModel.createTask(context, name.text, description.text, priority)
                Toast.makeText(context, "Task Created", Toast.LENGTH_LONG).show()
                name = TextFieldValue("")
                description = TextFieldValue("")
                priority = 5 // Reset to default priority
                errorMessage = ""
            } else {
                errorMessage = "Name and Description cannot be empty"
                Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
            }
        }) {
            Text("Create Task")
        }
    }
}
