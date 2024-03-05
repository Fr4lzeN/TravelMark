package com.example.travelmark.domain.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tag(
    @PrimaryKey
    val id: String,
    val latitude: Double,
    val longitude: Double,
    val description: String,
    val image: String? = null,
    val likes: Int = 0,
    val isLiked: Boolean = false,
    @Embedded
    val user: User? = null
)

