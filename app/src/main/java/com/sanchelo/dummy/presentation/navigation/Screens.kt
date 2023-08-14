package com.sanchelo.dummy.presentation.navigation

sealed class MainScreens(val route: String) {
    data object MainScreen : MainScreens("main_screen")
    data object DetailScreen : MainScreens("detail_screen")
}

sealed class AuthScreens(val route: String) {
    data object LoginScreen : MainScreens("login_screen")
    data object SignUpScreen : MainScreens("signup")
    data object ForgetPasswordScreen : MainScreens("forget_password")
    data object MainScreen : MainScreens("main")

}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTIFICATION = "auth_graph"
    const val MAIN = "main_graph"
}
