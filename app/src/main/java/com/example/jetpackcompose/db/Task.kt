package com.example.jetpackcompose.db

data class Task(
    val id: Int,
    val name: String,
    val createdDate: String
)

val task = listOf(
    Task(1, "Fetch the ball", "2023-04-20"),
    Task(2, "Enjoy a relaxing nap", "2023-04-19"),
    Task(3, "Play with squeaky toys", "2023-04-18"),
    Task(4, "Go for a walk", "2023-04-17"),
    Task(5, "Cuddle on the couch", "2023-04-16"),
    Task(6, "Enjoy a tasty treat", "2023-04-15"),
    Task(7, "Play in the backyard", "2023-04-14"),
    Task(8, "Go to the dog park", "2023-04-13"),
    Task(9, "Learn a new trick", "2023-04-12")
)