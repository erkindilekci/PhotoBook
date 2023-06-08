package com.erkindilekci.photobook.presentation.searchscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.erkindilekci.photobook.presentation.util.ScreenContent

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchScreenViewModel = hiltViewModel()
) {
    val searchQuery by viewModel.searchQuery
    val searchedImages = viewModel.searchedImages.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            SearchScreenAppBar(
                text = searchQuery,
                onTextChange = { viewModel.updateSearchQuery(it) },
                onSearchClicked = { viewModel.searchImages(it) },
                onCloseClicked = { navController.popBackStack() },
            )
        },
        content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
                ScreenContent(images = searchedImages)
            }
        }
    )
}
