package com.example.travelmark.domain.repository

import com.example.travelmark.domain.model.AuthData

interface AuthDBRepository {

    fun insertAuthData(authData: AuthData)

    fun getData(): AuthData


    fun updateAuthData(authData: AuthData)


    fun deleteAuthData()
}