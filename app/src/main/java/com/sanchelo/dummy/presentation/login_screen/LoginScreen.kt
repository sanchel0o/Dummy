package com.sanchelo.dummy.presentation.login_screen

import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sanchelo.dummy.presentation.navigation.Screens

@Composable
fun LoginScreen(
    navController: NavController
) {
    Text(text = "This is login screen", fontSize = 25.sp)
    Button(onClick = { navController.navigate(Screens.MainScreen.route) }) {
    }
}