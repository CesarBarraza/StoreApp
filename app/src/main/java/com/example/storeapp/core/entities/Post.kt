package com.example.jetpackcomposeapp.core.entities
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
) : Parcelable