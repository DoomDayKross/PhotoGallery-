package com.example.photogallery.model

import android.net.Uri

data class Photo(
    val uri: Uri,
    val timestamp: Long = System.currentTimeMillis()
)