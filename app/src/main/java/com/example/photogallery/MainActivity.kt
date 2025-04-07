package com.example.photogallery

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.photogallery.model.Photo
import com.example.photogallery.ui.GalleryScreen
import com.example.photogallery.ui.PhotoDetailScreen
import com.example.photogallery.viewmodel.GalleryViewModel
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: GalleryViewModel = viewModel()
            val photos by viewModel.photos.collectAsState()
            val currentPhoto by viewModel.currentPhoto.collectAsState()
            var showDetail by remember { mutableStateOf(false) }

            if (showDetail && currentPhoto != null) {
                PhotoDetailScreen(
                    photo = currentPhoto!!,
                    onPrevious = viewModel::previousPhoto,
                    onNext = viewModel::nextPhoto
                )
            } else {
                GalleryScreen(
                    photos = photos,
                    onPhotoClick = {
                        viewModel.setCurrentIndex(it)
                        showDetail = true
                    },
                    onAddClick = {
                        val fakeUri = Uri.parse("https://picsum.photos/200/300?random=${photos.size}")
                        viewModel.addPhoto(Photo(uri = fakeUri))
                    }
                )
            }
        }
    }
}
