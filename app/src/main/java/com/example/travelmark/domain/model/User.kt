package com.example.travelmark.domain.model

import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("id")
    val userId: String,
    val username: String,
){
    override fun toString(): String {
        return "User(id='$userId', username='$username')"
    }
}
