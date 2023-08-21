package com.sanchelo.dummy.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.sanchelo.dummy.presentation.detail_screen.screen.DetailScreen
import com.sanchelo.dummy.presentation.login_screen.screen.LoginScreen
import com.sanchelo.dummy.presentation.main_screen.screen.MainScreen

@Composable
fun Navigation() {
    RootGraph(navHostController = rememberNavController())
}

@Composable
fun RootGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTIFICATION
    ) {
        authNavGraph(navHostController)
        mainNavGraph(navHostController)
    }
}

fun NavGraphBuilder.mainNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.MAIN,
        startDestination = MainScreens.MainScreen.route
    ) {
        composable(route = MainScreens.MainScreen.route) {
            MainScreen(
                navigateToDetailScreen = {
                    navHostController.navigate(MainScreens.DetailScreen.route)
                }
            )
        }
        composable(route = MainScreens.DetailScreen.route) {
            DetailScreen(navigateBack = {
                navHostController.navigateUp()
            })
        }
    }
}

fun NavGraphBuilder.authNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.AUTHENTIFICATION,
        startDestination = AuthScreens.LoginScreen.route
    ) {
        composable(route = AuthScreens.LoginScreen.route) {
            LoginScreen(
//                navigateToMainScreen = {
//                    navHostController.popBackStack()
//                    navHostController.navigate(Graph.MAIN)
//                }
            )
        }
    }
}
