package com.example.travelmark.data.repository

import com.example.travelmark.data.data_source.dao.TagsDAO
import com.example.travelmark.domain.model.Tag
import com.example.travelmark.domain.repository.TagsDBRepository

class TagsDBRepositoryImpl(
    private val tagsDAO: TagsDAO,
) : TagsDBRepository {

    override suspend fun deleteTags() {
        tagsDAO.deleteTags()
    }

    override suspend fun getTags(): List<Tag> {
        return tagsDAO.getTags()
    }

    override suspend fun updateTag(tag: Tag) {
        tagsDAO.updateTag(tag)
    }

    override suspend fun deleteTag(tag: Tag) {
        tagsDAO.deleteTag(tag)
    }

    override suspend fun insertTag(tag: Tag) {
        tagsDAO.insertTag(tag)
    }

}