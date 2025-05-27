package com.example.storeapp.core.remote.repositories

import com.example.jetpackcomposeapp.core.entities.User
import com.example.storeapp.core.remote.ApiClient
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiClient: ApiClient) {
    suspend fun getUsers() : MutableList<User> {
        return apiClient.getUsers()
    }
}