package com.example.jetpackcompose.db

import androidx.annotation.StringRes
import com.example.jetpackcompose.R
data class Task(
    val id: Int,
    @StringRes val name: Int,
    @StringRes val createdDate: Int
)

val tasks = listOf(
    Task(1, R.string.fetch_the_ball, R.string.fecha1),
    Task(2, R.string.enjoy_a_relaxing_nap, R.string.fecha2),
    Task(3, R.string.play_with_squeaky_toys, R.string.fecha3),
    Task(4, R.string.go_for_a_walk, R.string.fecha4),
    Task(5, R.string.cuddle_on_the_couch, R.string.fecha5),
    Task(6, R.string.enjoy_a_tasty_treat, R.string.fecha6),
    Task(7, R.string.play_in_the_backyard, R.string.fecha7),
    Task(8, R.string.go_to_the_dog_park, R.string.fecha8),
    Task(9, R.string.learn_a_new_trick, R.string.fecha9),
    Task(10,R.string.take_a_bath, R.string.fecha10),
    Task(11,R.string.play_hide_and_seek, R.string.fecha11),
    Task(12, R.string.go_for_a_car_ride, R.string.fecha12),
    Task(13, R.string.chase_squirrels, R.string.fecha13),
    Task(14, R.string.dig_in_the_garden, R.string.fecha14),
    Task(15, R.string.guard_the_house, R.string.fecha15),
    Task(16, R.string.play_tug_of_war, R.string.fecha16),
    Task(17, R.string.attend_obedience_class, R.string.fecha17),
    Task(18, R.string.visit_the_groomer, R.string.fecha18),
    Task(19, R.string.learn_a_new_command, R.string.fecha19),
    Task(20, R.string.explore_a_new_trail, R.string.fecha20),
    Task(21, R.string.attend_a_doggy_birthday_party, R.string.fecha21),
    Task(22, R.string.learn_to_play_dead, R.string.fecha22),
    Task(23, R.string.practice_recall_training, R.string.fecha23),
    Task(24, R.string.go_camping_with_your_human, R.string.fecha24),
    Task(25, R.string.visit_a_dog_friendly_restaurant, R.string.fecha25)
)