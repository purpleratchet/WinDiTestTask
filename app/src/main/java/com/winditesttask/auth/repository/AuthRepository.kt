package com.winditesttask.auth.repository

import com.winditesttask.data.remote.ApiService

class AuthRepository(private val apiService: ApiService) {
    suspend fun sendAuthCode(phone: String) = apiService.sendAuthCode(phone)

    suspend fun checkAuthCode(phone: String, code: String) = apiService.checkAuthCode(phone, code)

    suspend fun register(phone: String, name: String, username: String) = apiService.register(phone, name, username)

    suspend fun refreshToken(token: String) = apiService.refreshToken(token)
}