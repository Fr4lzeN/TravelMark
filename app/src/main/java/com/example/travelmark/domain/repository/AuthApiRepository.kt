package com.example.travelmark.domain.repository

import com.example.travelmark.domain.model.Token
import com.example.travelmark.domain.model.User

interface AuthApiRepository {

    suspend fun signIn(username: String, password: String): Result<Token>

    suspend fun signUp(username: String, password: String): Result<User>

}