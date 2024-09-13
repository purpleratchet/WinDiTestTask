package com.winditesttask.data.remote

import com.winditesttask.data.local.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {
    @POST("/api/v1/users/send-auth-code/")
    suspend fun sendAuthCode(@Body phone: String): Response<Unit>

    @POST("/api/v1/users/check-auth-code/")
    suspend fun checkAuthCode(@Body phone: String, @Body code: String): Response<AuthResponse>

    @POST("/api/v1/users/register/")
    suspend fun register(@Body phone: String, @Body name: String, @Body username: String): Response<AuthResponse>

    @GET("/api/v1/users/me/")
    suspend fun getUserProfile(): Response<User>

    @PUT("/api/v1/users/me/")
    suspend fun updateUserProfile(@Body user: User): Response<User>

    @POST("/api/v1/users/refresh-token/")
    suspend fun refreshToken(@Body token: String): Response<AuthResponse>
}