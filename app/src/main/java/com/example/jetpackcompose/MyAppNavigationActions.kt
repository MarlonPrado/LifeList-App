package com.example.jetpackcompose
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.jetpackcompose.R

class MyAppNavigationActions(private val navController: NavHostController) {
    fun navigateTo(destination: MyAppTopLevelDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
        }
    }
}

data class MyAppTopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val iconTextId: Int
)
val TOP_LEVEL_DESTINATIONS = listOf(
    MyAppTopLevelDestination(
        route = MyAppRoute.HOME,
        selectedIcon = Icons.Default.Home,
        iconTextId = R.string.home
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.TASK,
        selectedIcon = Icons.Default.Add,
        iconTextId = R.string.task
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.TASKFINISHED,
        selectedIcon = Icons.Default.Check,
        iconTextId = R.string.taskfinished
    ),
    MyAppTopLevelDestination(
        route = MyAppRoute.PROFILE,
        selectedIcon = Icons.Default.AccountCircle,
        iconTextId = R.string.profile
    )
)

object MyAppRoute {
    const val LOGIN = "login"
    const val HOME = "home"
    const val TASK = "task"
    const val TASKFINISHED = "taskfinished"
    const val PROFILE = "profile"
}