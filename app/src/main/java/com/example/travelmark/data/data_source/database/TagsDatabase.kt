package com.example.travelmark.data.data_source.database

import androidx.room.RoomDatabase
import com.example.travelmark.data.data_source.dao.TagsDAO
import javax.inject.Singleton

@Singleton
abstract class TagsDatabase : RoomDatabase() {

    abstract fun tagsDao(): TagsDAO

    companion object{
        const val DATABASE_NAME="TagsDatabase"
    }

}