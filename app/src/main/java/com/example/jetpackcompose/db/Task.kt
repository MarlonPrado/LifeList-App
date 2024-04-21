package com.example.jetpackcompose.db

import androidx.annotation.StringRes
import com.example.jetpackcompose.R
data class Task(
    val id: Int,
    @StringRes val name: Int,
    val createdDate: String
)

val task = listOf(
    Task(1, R.string.fetch_the_ball, "2023-04-20"),
    Task(2, R.string.enjoy_a_relaxing_nap, "2023-04-19"),
    Task(3, R.string.play_with_squeaky_toys, "2023-04-18"),
    Task(4, R.string.go_for_a_walk, "2023-04-17"),
    Task(5, R.string.cuddle_on_the_couch, "2023-04-16"),
    Task(6, R.string.enjoy_a_tasty_treat, "2023-04-15"),
    Task(7, R.string.play_in_the_backyard, "2023-04-14"),
    Task(8, R.string.go_to_the_dog_park, "2023-04-13"),
    Task(9, R.string.learn_a_new_trick, "2023-04-12"),
    Task(10,R.string.take_a_bath, "2023-04-11"),
    Task(11,R.string.play_hide_and_seek, "2023-04-10"),
    Task(12, R.string.go_for_a_car_ride, "2023-04-09"),
    Task(13, R.string.chase_squirrels, "2023-04-08"),
    Task(14, R.string.dig_in_the_garden, "2023-04-07"),
    Task(15, R.string.guard_the_house, "2023-04-06"),
    Task(16, R.string.play_tug_of_war, "2023-04-05"),
    Task(17, R.string.attend_obedience_class, "2023-04-04"),
    Task(18, R.string.visit_the_groomer, "2023-04-03"),
    Task(19, R.string.learn_a_new_command, "2023-04-02"),
    Task(20, R.string.explore_a_new_trail, "2023-04-01"),
    Task(21, R.string.attend_a_doggy_birthday_party, "2023-03-22"),
    Task(22, R.string.learn_to_play_dead, "2023-03-21"),
    Task(23, R.string.practice_recall_training, "2023-03-20"),
    Task(24, R.string.go_camping_with_your_human, "2023-03-19"),
    Task(25, R.string.visit_a_dog_friendly_restaurant, "2023-03-18")
)