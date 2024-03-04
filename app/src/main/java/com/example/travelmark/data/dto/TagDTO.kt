package com.example.travelmark.data.dto

import com.google.gson.annotations.SerializedName

data class TagDTO(
    val id: String,
    val latitude: Double,
    val longitude: Double,
    val description: String,
    val image: String? = null,
    val likes: Int = 0,
    @SerializedName("is_liked")
    val isLiked: Boolean = false,
    val user: UserDTO? = null
)
