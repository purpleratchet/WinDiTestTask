package com.winditesttask.user.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winditesttask.data.local.User
import com.winditesttask.user.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    val userProfile = MutableLiveData<User>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    fun getUserProfile() {
        viewModelScope.launch {
            try {
                loading.value = true
                val response = userRepository.getUserProfile()
                loading.value = false
                if (response.isSuccessful) {
                    userProfile.value = response.body()
                } else {
                    error.value = "Error fetching profile"
                }
            } catch (e: Exception) {
                loading.value = false
                error.value = e.message
            }
        }
    }

    fun updateUserProfile(user: User) {
        viewModelScope.launch {
            try {
                loading.value = true
                val response = userRepository.updateUserProfile(user)
                loading.value = false
                if (response.isSuccessful) {
                    userProfile.value = response.body()
                } else {
                    error.value = "Error updating profile"
                }
            } catch (e: Exception) {
                loading.value = false
                error.value = e.message
            }
        }
    }
}