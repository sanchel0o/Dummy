package com.sanchelo.dummy.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sanchelo.dummy.presentation.detail_screen.DetailScreen
import com.sanchelo.dummy.presentation.login_screen.LoginScreen
import com.sanchelo.dummy.presentation.main_screen.screen.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.LoginScreen.route) {
        composable(Screens.LoginScreen.route) { LoginScreen(navController) }
        composable(Screens.MainScreen.route) { MainScreen(navController) }
        composable(Screens.DetailScreen.route) { DetailScreen(navController) }
    }
}
