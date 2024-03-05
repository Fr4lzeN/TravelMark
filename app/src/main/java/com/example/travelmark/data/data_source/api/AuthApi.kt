package com.example.travelmark.data.data_source.api

import com.example.travelmark.data.dto.SignInBody
import com.example.travelmark.data.dto.SignInDTO
import com.example.travelmark.data.dto.SignUpDTO
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApi {

    companion object {
        const val BASE_URL = "https://maps.rtuitlab.dev/"
    }

    @POST("/api/auth/jwt/login")
    suspend fun signIn(
        @Body body: RequestBody
    ): Response<SignInDTO>


    @POST("/api/auth/register")
    @Headers(
        "accept: application/json",
        "Content-Type: application/json"
    )
    suspend fun signUp(
        @Body body: SignInBody
    ): Response<SignUpDTO>


}