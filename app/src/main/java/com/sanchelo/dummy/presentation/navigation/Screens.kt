package com.sanchelo.dummy.presentation.navigation

sealed class MainScreens(val route: String) {
    data object MainScreen : MainScreens("main_screen")
    data object DetailScreen : MainScreens("detail_screen")
}

sealed class StartUpScreens(val route: String) {
    data object SplashScreen : MainScreens("splash")
    data object LoginScreen : MainScreens("login_screen")
    data object SignUpScreen : MainScreens("signup")
    data object ForgetPasswordScreen : MainScreens("forget_password")
    data object MainScreen : MainScreens("main")

}
