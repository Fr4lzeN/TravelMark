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
    suspend fun deleteTags()

    @Query("SELECT * FROM tag")
    suspend fun getTags():List<Tag>

    @Update
    suspend fun updateTag(tag: Tag)

    @Delete
    suspend fun deleteTag(tag: Tag)

    @Insert
    suspend fun insertTag(tag: Tag)

}