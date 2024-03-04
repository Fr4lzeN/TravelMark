package com.example.travelmark.data.repository

import com.example.travelmark.core.Error
import com.example.travelmark.data.data_source.TagsApi
import com.example.travelmark.data.dto.TagDTO
import com.example.travelmark.data.dto.UserDTO
import com.example.travelmark.domain.model.Tag
import com.example.travelmark.domain.model.User
import com.example.travelmark.domain.repository.TagsApiRepository
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.InputStream

class TagsApiRepositoryImpl(
    private val tagsApi: TagsApi,
) : TagsApiRepository {

    override suspend fun getTags(
        image: String?,
        imageNeq: String?,
        orderBy: String?,
        userId: String?,
        username: String?
    ): Result<List<Tag>> {
        val response = tagsApi.getTags(
            image,
            imageNeq,
            orderBy,
            userId,
            username
        )
        if (response.isSuccessful) {
            return Result.success(response.body()!!.map { it.toTag() })
        }
        return Result.failure(Error.GetTagError)

    }

    override suspend fun createTag(
        latitude: Double,
        longitude: Double,
        description: String,
        image: InputStream?,
        token: String?
    ): Result<Tag> {
        val imageBody =
            image?.readBytes()?.let { RequestBody.create(MediaType.parse("image/*"), it) }
        val imagePart = imageBody?.let { MultipartBody.Part.createFormData("image", ".jpg", it) }
        image?.close()
        val response = tagsApi.createTag(latitude, longitude, description, imagePart, token)
        if (response.isSuccessful) {
            return Result.success(response.body()!!.toTag())
        }
        return Result.failure(Error.CreateTagError)
    }

    override suspend fun deleteTag(tagId: String, token: String?): Result<Unit> {
        val response = tagsApi.deleteTag(tagId, token)
        if (response.isSuccessful) {
            return Result.success(Unit)
        }
        return Result.failure(Error.DeleteTagError)
    }

    override suspend fun likeTag(tagId: String, token: String?): Result<Tag> {
        val response = tagsApi.likeTag(tagId, token)
        if (response.isSuccessful) {
            return Result.success(response.body()!!.toTag())
        }
        return Result.failure(Error.LikeTagError)
    }

    override suspend fun deleteLike(tagId: String, token: String?): Result<Unit> {
        val response = tagsApi.deleteLikeTag(tagId, token)
        if (response.isSuccessful) {
            return Result.success(Unit)
        }
        return Result.failure(Error.DeleteLikeTagError)
    }

    private fun TagDTO.toTag(): Tag {
        return Tag(
            this.id,
            this.latitude,
            this.longitude,
            this.description,
            this.image,
            this.likes,
            this.isLiked,
            this.user?.toUser()
        )
    }

    private fun UserDTO.toUser(): User {
        return User(
            this.id,
            this.username,
        )
    }

}