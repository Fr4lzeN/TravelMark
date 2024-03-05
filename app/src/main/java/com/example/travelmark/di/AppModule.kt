package com.example.travelmark.di

import android.app.Application
import androidx.room.Room
import com.example.travelmark.data.data_source.api.AuthApi
import com.example.travelmark.data.data_source.api.TagsApi
import com.example.travelmark.data.data_source.database.AuthDatabase
import com.example.travelmark.data.data_source.database.TagsDatabase
import com.example.travelmark.data.repository.AuthApiRepositoryImpl
import com.example.travelmark.data.repository.AuthDBRepositoryImpl
import com.example.travelmark.data.repository.ImageRepositoryImpl
import com.example.travelmark.data.repository.TagsApiRepositoryImpl
import com.example.travelmark.data.repository.TagsDBRepositoryImpl
import com.example.travelmark.domain.repository.AuthApiRepository
import com.example.travelmark.domain.repository.AuthDBRepository
import com.example.travelmark.domain.repository.ImageRepository
import com.example.travelmark.domain.repository.TagsApiRepository
import com.example.travelmark.domain.repository.TagsDBRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTagsDatabase(app: Application): TagsDatabase {
        return Room.databaseBuilder(
            app,
            TagsDatabase::class.java,
            TagsDatabase.DATABASE_NAME,
        ).build()
    }

    @Provides
    @Singleton
    fun provideAuthDatabase(app: Application): AuthDatabase {
        return Room.databaseBuilder(
            app,
            AuthDatabase::class.java,
            AuthDatabase.DATABASE_NAME,
        ).build()
    }

    @Provides
    @Singleton
    fun provideTagsApi(): TagsApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(TagsApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(TagsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthApi(): AuthApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(AuthApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthApiRepository(authApi: AuthApi): AuthApiRepository{
        return AuthApiRepositoryImpl(authApi)
    }
    @Provides
    @Singleton
    fun provideAuthDBRepository(authDatabase: AuthDatabase): AuthDBRepository {
        return AuthDBRepositoryImpl(authDatabase.authDao())
    }

    @Provides
    @Singleton
    fun provideTagsApiRepository(tagsApi: TagsApi): TagsApiRepository {
        return TagsApiRepositoryImpl(tagsApi)
    }

    @Provides
    @Singleton
    fun provideTagsDBRepository(tagsDatabase: TagsDatabase): TagsDBRepository {
        return TagsDBRepositoryImpl(tagsDatabase.tagsDao())
    }

    @Provides
    @Singleton
    fun provideImageRepository(app: Application): ImageRepository{
        return ImageRepositoryImpl(app.contentResolver)
    }




}