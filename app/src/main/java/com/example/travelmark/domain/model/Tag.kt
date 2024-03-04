package com.example.travelmark.domain.model

data class Tag(
    val id: String,
    val latitude: Double,
    val longitude: Double,
    val description: String,
    val image: String? = null,
    val likes: Int = 0,
    val is_liked: Boolean = false,
    val user: User? = null
)

