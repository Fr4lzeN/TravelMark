package com.example.travelmark.domain.repository

import com.example.travelmark.domain.model.Tag

interface TagsDBRepository {

    suspend fun deleteTags()


    suspend fun getTags(): List<Tag>


    suspend fun updateTag(tag: Tag)


    suspend fun deleteTag(tag: Tag)


    suspend fun insertTag(tag: Tag)

}