package com.example.travelmark.data.repository

import com.example.travelmark.data.data_source.dao.TagsDAO
import com.example.travelmark.domain.model.Tag
import com.example.travelmark.domain.repository.TagsDBRepository

class TagsDBRepositoryImpl(
    private val tagsDAO: TagsDAO,
) : TagsDBRepository {

    override fun deleteTags() {
        tagsDAO.deleteTags()
    }

    override fun getTags(): List<Tag> {
        return tagsDAO.getTags()
    }

    override fun updateTag(tag: Tag) {
        tagsDAO.updateTag(tag)
    }

    override fun deleteTag(tag: Tag) {
        tagsDAO.deleteTag(tag)
    }

    override fun insertTag(tag: Tag) {
        tagsDAO.insertTag(tag)
    }

}