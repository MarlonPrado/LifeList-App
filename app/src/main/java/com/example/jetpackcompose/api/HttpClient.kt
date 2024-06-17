package com.example.jetpackcompose.api

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response

class HttpClient {
    private val client = OkHttpClient()

    fun createRequest(url: String, method: String, requestBody: RequestBody? = null): Request {
        val request = Request.Builder()
            .url(url)
            .method(method, requestBody)
            .build()
        return request
    }

    fun executeRequest(request: Request): Response {
        return client.newCall(request).execute()
    }
}