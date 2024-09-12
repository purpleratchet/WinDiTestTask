package com.winditesttask.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUserById(id: String): User?

    @Query("SELECT * FROM user LIMIT 1")
    suspend fun getCurrentUser(): User?

    @Update
    suspend fun updateUser(user: User)

    @Query("DELETE FROM user WHERE id = :id")
    suspend fun deleteUserById(id: String)
}