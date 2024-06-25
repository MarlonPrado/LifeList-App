package com.example.jetpackcompose.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.jetpackcompose.models.LoginRequest
import com.example.jetpackcompose.api.RetrofitInstance
import com.example.jetpackcompose.navigation.MyAppRoute
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {
    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    fun onUsernameChange(newUsername: String) {
        _username.value = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun login(navController: NavController, context: Context) {
        _isLoading.value = true
        _errorMessage.value = null

        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.login(LoginRequest(_username.value, _password.value))
                if (response.isSuccessful) {
                    response.body()?.let { loginResponse ->
                        val sharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
                        with(sharedPreferences.edit()) {
                            putString("TOKEN", loginResponse.token)
                            putString("USERNAME", _username.value)
                            apply()
                        }
                        _isLoggedIn.value = true
                        navController.navigate(MyAppRoute.HOME) {
                            popUpTo(MyAppRoute.LOGIN) { inclusive = true }
                        }
                    } ?: run {
                        _errorMessage.value = "Invalid response from server"
                    }
                } else {
                    _errorMessage.value = "Invalid credentials"
                }
            } catch (e: Exception) {
                _errorMessage.value = "An error occurred: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
