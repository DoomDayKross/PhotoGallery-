package com.example.photogallery.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.photogallery.model.Photo

@Composable
fun GalleryScreen(
    photos: List<Photo>,
    onPhotoClick: (Int) -> Unit,
    onAddClick: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Icon(Icons.Default.Add, contentDescription = "Add Photo")
            }
        }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            itemsIndexed(photos) { index, photo ->
                Image(
                    painter = rememberAsyncImagePainter(photo.uri),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(4.dp)
                        .aspectRatio(1f)
                        .clickable { onPhotoClick(index) }
                )
            }
        }
    }
}
