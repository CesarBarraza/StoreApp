package com.example.storeapp.core.remote.repositories

import com.example.jetpackcomposeapp.core.entities.Post
import com.example.storeapp.core.remote.ApiClient
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiClient: ApiClient) {
    suspend fun getPosts(): MutableList<Post> {
        return apiClient.getPosts()
    }

    suspend fun getPostById(id:Int): Post {
        return apiClient.getPostById(id)
    }
}