package com.example.travelmark.data.data_source

import com.example.travelmark.data.dto.SignInDTO
import com.example.travelmark.data.dto.SignUpDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers

interface AuthApi {

    companion object {
        const val BASE_URL = "https://maps.rtuitlab.dev/"
    }

    @FormUrlEncoded
    @GET("/api/auth/jwt/login")
    @Headers(
        "accept: application/json",
        "Content-Type: application/x-www-form-urlencoded"
    )
    fun signIn(
        @Body username: String,
        @Body password: String,
    ): Response<SignInDTO>


    @GET("/api/auth/register")
    @Headers(
        "accept: application/json",
        "Content-Type: application/json"
    )
    fun signUp(
        @Body username: String,
        @Body password: String,
    ): Response<SignUpDTO>


}