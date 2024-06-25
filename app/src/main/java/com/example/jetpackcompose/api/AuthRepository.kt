package com.example.jetpackcompose.api

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody

class AuthRepository(private val api: AuthApi) {
    private val httpClient = HttpClient()

    suspend fun login(username: String, password: String): ResponseBody {
        val requestBody = RequestBody.create("application/json".toMediaType(), "{\"username\":\"$username\",\"password\":\"$password\"}")
        val request = httpClient.createRequest("https://api.example.com/tokens/", "POST", requestBody)
        val response = httpClient.executeRequest(request)
        return response.body!!
    }
}