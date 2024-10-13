package com.example.pokeapp

sealed class ScreenRoute(val route: String) {
    object SearchScreen: ScreenRoute("search_screen")
    object ResultScreen: ScreenRoute("result_screen")
}