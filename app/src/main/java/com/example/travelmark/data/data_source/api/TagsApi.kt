package com.example.travelmark.data.data_source.api

import com.example.travelmark.data.dto.TagDTO
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface TagsApi {

    companion object {
        const val BASE_URL = "https://maps.rtuitlab.dev/"
    }

    @GET("/api/tags/")
    suspend fun getTags(
        @Query("image") image: String? = null,
        @Query("image_neq") imageNeq: String? = null,
        @Query("order_by") orderBy: String? = null,
        @Query("user_id") userId: String? = null,
        @Query("user_username") username: String? = null
    ): Response<List<TagDTO>>

    @Multipart
    @POST("/api/tags/")
    suspend fun createTag(
        @Part("latitude") latitude: Double,
        @Part("longitude") longitude: Double,
        @Part("description") description: String,
        @Part image: MultipartBody.Part? = null,
        @Header("Authorization") token: String? = null
    ): Response<TagDTO>

    @DELETE("/api/tags/{tag_id}")
    suspend fun deleteTag(
        @Path("tag_id") tagId: String,
        @Header("Authorization") token: String? = null,
    ): Response<String>

    @POST("/api/tags/{tag_id}/likes")
    suspend fun likeTag(
        @Path("tag_id") tagId: String,
        @Header("Authorization") token: String? = null
    ): Response<TagDTO>

    @DELETE("/api/tags/{tag_id}/likes")
    suspend fun deleteLikeTag(
        @Path("tag_id") tagId: String,
        @Header("Authorization") token: String? = null
    ): Response<String>


}