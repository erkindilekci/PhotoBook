package com.erkindilekci.photobook.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.erkindilekci.photobook.presentation.listscreen.ListScreen
import com.erkindilekci.photobook.presentation.searchscreen.SearchScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.List.route) {
        composable(Screen.List.route) {
            ListScreen(navController)
        }
        composable(Screen.Search.route) {
            SearchScreen(navController)
        }
    }
}
