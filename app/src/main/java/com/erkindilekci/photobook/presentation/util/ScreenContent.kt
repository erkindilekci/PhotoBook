package com.erkindilekci.photobook.presentation.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.erkindilekci.photobook.model.Image

@Composable
fun ScreenContent(images: LazyPagingItems<Image>) {
    println("Error: ${images.loadState}")
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = images) {
            it?.let { image ->
                ImageCard(image = image)
            }
        }
    }
}
