package com.example.jetpackcompose.api

import com.example.jetpackcompose.models.LoginRequest
import com.example.jetpackcompose.models.LoginResponse
import com.example.jetpackcompose.models.TaskResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("s/")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("/api/tasks/?format=json")
    suspend fun getTasks(@Header("Authorization") authHeader: String): Response<TaskResponse>
}
