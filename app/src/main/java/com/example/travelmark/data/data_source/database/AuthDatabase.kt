package com.example.travelmark.data.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.travelmark.data.data_source.dao.AuthDAO
import com.example.travelmark.domain.model.AuthData
import javax.inject.Singleton

@Singleton
@Database(
    entities = [AuthData::class],
    version = 1
)
abstract class AuthDatabase: RoomDatabase() {

    abstract fun authDao(): AuthDAO

    companion object{
        const val DATABASE_NAME="AuthDatabase"
    }

}