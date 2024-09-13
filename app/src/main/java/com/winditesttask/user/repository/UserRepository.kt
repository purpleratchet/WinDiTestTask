package com.winditesttask.user.repository

import com.winditesttask.data.local.User
import com.winditesttask.data.remote.ApiService

class UserRepository(private val apiService: ApiService) {
    suspend fun getUserProfile() = apiService.getUserProfile()

    suspend fun updateUserProfile(user: User) = apiService.updateUserProfile(user)
}