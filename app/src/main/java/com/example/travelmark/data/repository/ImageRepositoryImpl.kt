package com.example.travelmark.data.repository

import android.content.ContentResolver
import android.net.Uri
import com.example.travelmark.domain.repository.ImageRepository
import java.io.InputStream

class ImageRepositoryImpl(
    private val contentResolver: ContentResolver,
): ImageRepository {
    override fun openInputStream(imageUri: Uri): InputStream? {
        return contentResolver.openInputStream(imageUri)
    }
}