package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginButton(
    label: String,
    onLoginButtonClicked: () -> Unit,
    isLoginButtonEnabled: Boolean
) {
    Button(
        modifier = Modifier.width(100.dp),
        onClick = { /*TODO*/ }
    ) {
        Text(text = label)
    }
}