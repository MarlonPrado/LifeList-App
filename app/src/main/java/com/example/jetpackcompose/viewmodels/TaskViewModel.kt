package com.example.jetpackcompose.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.api.RetrofitInstance
import com.example.jetpackcompose.models.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun fetchTasks(context: Context) {
        _isLoading.value = true
        _errorMessage.value = null

        viewModelScope.launch {
            try {
                val sharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
                val token = sharedPreferences.getString("TOKEN", null) ?: throw Exception("Token not found")

                Log.d("TaskViewModel", "Fetching tasks with token: $token")

                val response = RetrofitInstance.api.getTasks("Token $token")

                if (response.isSuccessful) {
                    response.body()?.let { taskResponse ->
                        _tasks.value = taskResponse.results
                        Log.d("TaskViewModel", "Tasks fetched successfully: ${taskResponse.results}")
                    } ?: run {
                        val errorMsg = "Invalid response from server"
                        _errorMessage.value = errorMsg
                        Log.e("TaskViewModel", errorMsg)
                    }
                } else {
                    val errorMsg = "Failed to fetch tasks. Error code: ${response.code()}, Error message: ${response.message()}"
                    _errorMessage.value = errorMsg
                    Log.e("TaskViewModel", errorMsg)
                }
            } catch (e: Exception) {
                val errorMsg = "An error occurred: ${e.message}"
                _errorMessage.value = errorMsg
                Log.e("TaskViewModel", errorMsg)
            } finally {
                _isLoading.value = false
                Log.d("TaskViewModel", "Loading state set to false")
            }
        }
    }
}
