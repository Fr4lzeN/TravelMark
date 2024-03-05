package com.example.travelmark.domain.repository

import com.example.travelmark.domain.model.Tag

interface TagsDBRepository {

    fun deleteTags()


    fun getTags():List<Tag>


    fun updateTag(tag: Tag)


    fun deleteTag(tag: Tag)


    fun insertTag(tag: Tag)

}