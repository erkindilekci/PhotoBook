package com.erkindilekci.photobook.presentation.listscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.erkindilekci.photobook.presentation.ui.theme.statusBarColor
import com.erkindilekci.photobook.presentation.util.ScreenContent
import com.erkindilekci.photobook.util.Screen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val images = viewModel.images.collectAsLazyPagingItems()

    val systemUiController = rememberSystemUiController()
    val statusBarColor = MaterialTheme.colorScheme.statusBarColor

    SideEffect {
        systemUiController.setStatusBarColor(statusBarColor)
        systemUiController.setNavigationBarColor(statusBarColor)
    }

    Scaffold(
        topBar = {
            ListScreenAppBar(onSearchClicked = { navController.navigate(Screen.Search.route) })
        },
        content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
                ScreenContent(images = images)
            }
        }
    )
}
