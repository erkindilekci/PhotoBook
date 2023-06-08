package com.erkindilekci.photobook.util

sealed class Screen(val route: String) {
    object List : Screen("list_screen")
    object Search : Screen("search_screen")
}
