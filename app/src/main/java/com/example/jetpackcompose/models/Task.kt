package com.example.jetpackcompose.models

data class Task(
    val id: Int,
    val name: String,
    val description: String,
    val priority: Int,
    val completed: Boolean
)

data class TaskResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Task>
)
