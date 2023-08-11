package com.sanchelo.dummy.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.sanchelo.dummy.presentation.detail_screen.DetailScreen
import com.sanchelo.dummy.presentation.login_screen.LoginScreen
import com.sanchelo.dummy.presentation.main_screen.screen.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = StartUpScreens.LoginScreen.route) {
        composable(StartUpScreens.LoginScreen.route) { LoginScreen(navController) }
        mainScreenGraph(navController)
    }
}

fun NavGraphBuilder.mainScreenGraph(navController: NavController) {
    navigation(startDestination = MainScreens.MainScreen.route , route = StartUpScreens.MainScreen.route) {
        composable(MainScreens.MainScreen.route) { MainScreen(navController) }
        composable(MainScreens.DetailScreen.route) { DetailScreen(navController) }
    }


}
