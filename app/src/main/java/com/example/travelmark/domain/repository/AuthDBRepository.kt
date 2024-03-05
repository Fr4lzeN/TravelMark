package com.example.travelmark.domain.repository

import com.example.travelmark.domain.model.AuthData

interface AuthDBRepository {

    suspend fun insertAuthData(authData: AuthData)

    suspend fun getData(): AuthData


    suspend fun updateAuthData(authData: AuthData)


    suspend fun deleteAuthData()
}