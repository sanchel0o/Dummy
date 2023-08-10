package com.sanchelo.dummy.presentation.navigation

sealed class Screens(val route: String) {
    data object MainScreen: Screens("main_screen")
    data object LoginScreen: Screens("login_screen")
    data object DetailScreen: Screens("detail_screen")

}
