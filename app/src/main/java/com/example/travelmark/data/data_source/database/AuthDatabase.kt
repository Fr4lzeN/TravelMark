package com.example.travelmark.data.data_source.database

import androidx.room.RoomDatabase
import com.example.travelmark.data.data_source.dao.AuthDAO
import javax.inject.Singleton

@Singleton
abstract class AuthDatabase: RoomDatabase() {

    abstract fun authDao(): AuthDAO

    companion object{
        const val DATABASE_NAME="AuthDatabase"
    }

}