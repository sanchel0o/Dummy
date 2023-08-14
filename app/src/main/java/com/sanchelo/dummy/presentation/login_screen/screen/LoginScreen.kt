package com.sanchelo.dummy.presentation.login_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sanchelo.dummy.presentation.navigation.MainScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navigateToMainScreen: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier,
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(value = "", onValueChange = {})
                OutlinedTextField(value = "", onValueChange = {})

                Button(
                    onClick = {
                        navigateToMainScreen()
                    }) {
                    Text(text = "Login")
                }

                TextButton(
                    onClick = {}
                ) {
                    Text(text = "Forget password?")
                }
            }
        }
    }
}
