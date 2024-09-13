package com.winditesttask.auth.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winditesttask.auth.repository.AuthRepository
import com.winditesttask.data.remote.AuthResponse
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepository: AuthRepository): ViewModel() {
    val authState = MutableLiveData<AuthResponse>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    fun sendAuthCode(phone: String) {
        viewModelScope.launch {
            try {
                loading.value = true
                val response = authRepository.sendAuthCode(phone)
                loading.value = false
                if (response.isSuccessful) {
                    // Handle success
                } else {
                    error.value = "Error sending auth code"
                }
            } catch (e: Exception) {
                loading.value = false
                error.value = e.message
            }
        }
    }

    fun checkAuthCode(phone: String, code: String) {
        viewModelScope.launch {
            try {
                loading.value = true
                val response = authRepository.checkAuthCode(phone, code)
                loading.value = false
                if (response.isSuccessful) {
                    authState.value = response.body()
                } else {
                    error.value = "Error checking auth code"
                }
            } catch (e: Exception) {
                loading.value = false
                error.value = e.message
            }
        }
    }
}