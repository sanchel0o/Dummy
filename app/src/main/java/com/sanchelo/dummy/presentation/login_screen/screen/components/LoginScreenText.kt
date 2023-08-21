package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

@Composable
fun LoginText() {
    Text(
        modifier = Modifier,
        style = TextStyle(
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontSize = 40.sp,
            fontFamily = FontFamily.Serif,
        ),
        text = "Login")
}