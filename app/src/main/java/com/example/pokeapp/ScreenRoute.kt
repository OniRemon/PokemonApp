package com.example.pokeapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenRoute(val route: String) {
    object SearchScreen: ScreenRoute("search_screen")
    object ResultScreen: ScreenRoute("result_screen")
}

sealed class BottomNavItem(val route: String, val icon: ImageVector, val title: String) {
    data object Home : BottomNavItem("home", Icons.Outlined.Home, "Home")
    data object Search : BottomNavItem("search", Icons.Outlined.Search, "Search")
    data object Favorite : BottomNavItem("favorite", Icons.Outlined.FavoriteBorder,"Favorite")
    data object Profile : BottomNavItem("profile", Icons.Outlined.AccountCircle, "Profile")
}