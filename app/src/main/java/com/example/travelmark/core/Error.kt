package com.example.travelmark.core

sealed class Error {

    object AuthError: Throwable()
    object GetTagError: Throwable()
    object CreateTagError: Throwable()
    object DeleteTagError: Throwable()
    object LikeTagError: Throwable()
    object DeleteLikeTagError: Throwable()

}