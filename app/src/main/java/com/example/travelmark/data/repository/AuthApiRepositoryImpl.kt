package com.example.travelmark.data.repository

import android.R.attr
import com.example.travelmark.core.Error
import com.example.travelmark.data.data_source.api.AuthApi
import com.example.travelmark.data.dto.SignInBody
import com.example.travelmark.data.dto.SignInDTO
import com.example.travelmark.data.dto.SignUpDTO
import com.example.travelmark.domain.model.Token
import com.example.travelmark.domain.model.User
import com.example.travelmark.domain.repository.AuthApiRepository
import okhttp3.MultipartBody


class AuthApiRepositoryImpl(
    private val authApi: AuthApi,
) : AuthApiRepository {

    override suspend fun signIn(username: String, password: String): Result<Token> {
        val requestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("username", username)
            .addFormDataPart("password", password)
            .build()
        val response = authApi.signIn(requestBody)
        if (response.isSuccessful) {
            return Result.success(response.body()!!.toToken())
        }
        return Result.failure(Error.AuthError)
    }

    override suspend fun signUp(username: String, password: String): Result<User> {
        val requestBody = SignInBody(username, password)
        val response = authApi.signUp(requestBody)
        if (response.isSuccessful) {
            return Result.success(response.body()!!.toUser())
        }
        return Result.failure(Error.AuthError)
    }

    private fun SignInDTO.toToken(): Token {
        return Token(this.access_token)
    }

    private fun SignUpDTO.toUser(): User {
        return User(this.id, this.username)
    }
}