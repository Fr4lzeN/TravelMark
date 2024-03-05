package com.example.travelmark.data.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.travelmark.data.data_source.dao.TagsDAO
import com.example.travelmark.domain.model.Tag
import javax.inject.Singleton

@Singleton
@Database(
    entities = [Tag::class],
    version = 1
)
abstract class TagsDatabase : RoomDatabase() {

    abstract fun tagsDao(): TagsDAO

    companion object{
        const val DATABASE_NAME="TagsDatabase"
    }

}