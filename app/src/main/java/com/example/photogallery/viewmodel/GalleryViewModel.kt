package com.example.photogallery.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photogallery.model.Photo
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class GalleryViewModel : ViewModel() {

    private val _photos = MutableStateFlow<List<Photo>>(emptyList())
    val photos: StateFlow<List<Photo>> = _photos

    private val currentIndex = MutableStateFlow(0)
    val currentPhoto: StateFlow<Photo?> = combine(_photos, currentIndex) { list, index ->
        list.getOrNull(index)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, null)

    fun setCurrentIndex(index: Int) {
        currentIndex.value = index
    }

    fun nextPhoto() {
        currentIndex.value = (currentIndex.value + 1).coerceAtMost(_photos.value.lastIndex)
    }

    fun previousPhoto() {
        currentIndex.value = (currentIndex.value - 1).coerceAtLeast(0)
    }

    fun addPhoto(photo: Photo) {
        _photos.value = _photos.value + photo
    }
}