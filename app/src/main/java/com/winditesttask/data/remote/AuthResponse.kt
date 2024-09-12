package com.winditesttask.data.remote

data class AuthResponse(
    val accessToken: String,
    val refreshToken: String,
    val userId: String,
    val isUserExists: Boolean
)