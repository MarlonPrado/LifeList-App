package com.example.jetpackcompose.api

import com.example.jetpackcompose.models.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("tokens/")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("/api/tasks/?format=json")
    suspend fun getTasks(@Header("Authorization") authHeader: String): Response<TaskResponse>

    @PATCH("/api/tasks/{id}/?format=json")
    suspend fun updateTaskStatus(
        @Header("Authorization") authHeader: String,
        @Path("id") taskId: Int,
        @Body status: Map<String, Boolean>
    ): Response<TaskResponse>

    @Headers("Content-Type: application/json")
    @POST("/api/tasks/?format=json")
    suspend fun createTask(
        @Header("Authorization") authHeader: String,
        @Body task: CreateTaskRequest
    ): Response<TaskResponse>
}
