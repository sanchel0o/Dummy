package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sanchelo.dummy.presentation.core.fontFamily

@Composable
fun LoginText(

) {
    Text(
        modifier = Modifier,
        style = TextStyle(
            color = MaterialTheme.colorScheme.primary,
            fontSize = 48.sp,
            fontFamily = fontFamily,
        ),
        text = "Login")
}