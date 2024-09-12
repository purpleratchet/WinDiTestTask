package com.winditesttask.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey
    val id: String,
    val phone: String,
    val name: String,
    val username: String,
    val avatarUrl: String,
    val city: String,
    val birthdate: String,
    val zodiacSign: String,
    val bio: String
)
