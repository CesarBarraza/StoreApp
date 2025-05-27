package com.example.storeapp.core.remote

import com.example.jetpackcomposeapp.core.entities.Post
import com.example.jetpackcomposeapp.core.entities.User
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiClient {
    @GET("posts")
    suspend fun getPosts():MutableList<Post>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") id: Int): Post

    @GET("users")
    suspend fun getUsers(): MutableList<User>
}