package com.example.travelmark.data.repository

import com.example.travelmark.core.EncryptionHelper
import com.example.travelmark.data.data_source.dao.AuthDAO
import com.example.travelmark.domain.model.AuthData
import com.example.travelmark.domain.repository.AuthDBRepository

class AuthDBRepositoryImpl(
    private val authDAO: AuthDAO
) : AuthDBRepository {

    override suspend fun insertAuthData(authData: AuthData) {
        val password = authData.password
        val encryptedPassword = EncryptionHelper.encryptPassword(password)
        val encryptedAuth = authData.copy(password = encryptedPassword)
        authDAO.insertAuthData(encryptedAuth)
    }

    override suspend fun getData(): AuthData {
        val encryptedAuth = authDAO.getData()
        val encryptedPassword = encryptedAuth.password
        val password = EncryptionHelper.decryptPassword(encryptedPassword)
        return encryptedAuth.copy(password = password)
    }

    override suspend fun updateAuthData(authData: AuthData) {
        val password = authData.password
        val encryptedPassword = EncryptionHelper.encryptPassword(password)
        val encryptedAuth = authData.copy(password = encryptedPassword)
        authDAO.insertAuthData(encryptedAuth)
    }

    override suspend fun deleteAuthData() {
        authDAO.deleteAuthData()
    }
}