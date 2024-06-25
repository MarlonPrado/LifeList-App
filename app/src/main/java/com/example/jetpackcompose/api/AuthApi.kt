package com.example.jetpackcompose.api

import okhttp3.ResponseBody

interface AuthApi {
    suspend fun login(username: String, password: String): ResponseBody
}