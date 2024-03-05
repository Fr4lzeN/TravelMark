package com.example.travelmark.domain.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AuthData(
    @PrimaryKey
    val id: Int = 0,
    val username: String,
    val password: String,
    @Embedded
    val token: Token? = null
)


