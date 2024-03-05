package com.example.travelmark.domain.repository

import com.example.travelmark.domain.model.Tag
import java.io.InputStream

interface TagsApiRepository {

    suspend fun getTags(
        image: String? = null,
        imageNeq: String? = null,
        orderBy: String? = null,
        userId: String? = null,
        username: String? = null
    ): Result<List<Tag>>

    suspend fun createTag(
        latitude: Double,
        longitude: Double,
        description: String,
        image: InputStream? = null,
        token: String? = null
    ): Result<Tag>

    suspend fun deleteTag(tagId: String, token: String? = null): Result<Unit>

    suspend fun likeTag(tagId: String, token: String? = null): Result<Tag>

    suspend fun deleteLike(tagId: String, token: String? = null): Result<Unit>

}