package com.example.jetpackcompose.api

import com.example.jetpackcompose.models.LoginRequest
import com.example.jetpackcompose.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("tokens/")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}
