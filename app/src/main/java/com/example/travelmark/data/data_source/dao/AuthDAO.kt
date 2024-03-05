package com.example.travelmark.data.data_source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.travelmark.domain.model.AuthData

@Dao
interface AuthDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAuthData(authData: AuthData)

    @Query("SELECT * FROM authdata LIMIT 1")
    fun getData():AuthData

    @Update
    fun updateAuthData(authData: AuthData)

    @Query("DELETE FROM authdata")
    fun deleteAuthData()
}