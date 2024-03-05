package com.example.travelmark.data.data_source.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.travelmark.domain.model.Tag

@Dao
interface TagsDAO {

    @Query("DELETE  FROM tag")
    fun deleteTags()

    @Query("SELECT * FROM tag")
    fun getTags():List<Tag>

    @Update
    fun updateTag(tag: Tag)

    @Delete
    fun deleteTag(tag: Tag)

    @Insert
    fun insertTag(tag: Tag)

}