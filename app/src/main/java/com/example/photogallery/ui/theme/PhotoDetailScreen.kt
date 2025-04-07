package com.example.photogallery.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.photogallery.model.Photo

@Composable
fun PhotoDetailScreen(
    photo: Photo,
    onPrevious: () -> Unit,
    onNext: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = rememberAsyncImagePainter(photo.uri),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onPrevious,
                modifier = Modifier.weight(1f)
            ) {
                Text("Previous")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = onNext,
                modifier = Modifier.weight(1f)
            ) {
                Text("Next")
            }
        }
    }
}
