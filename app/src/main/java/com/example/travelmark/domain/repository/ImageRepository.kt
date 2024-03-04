package com.example.travelmark.domain.repository

import android.net.Uri
import java.io.InputStream

interface ImageRepository {

    fun openInputStream(imageUri: Uri): InputStream?

}