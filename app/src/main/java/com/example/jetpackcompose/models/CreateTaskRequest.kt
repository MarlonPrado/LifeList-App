package com.example.jetpackcompose.models

data class CreateTaskRequest(
    val name: String,
    val description: String,
    val priority: Int
)
