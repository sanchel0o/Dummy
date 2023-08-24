package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.sanchelo.dummy.presentation.core.fontFamily
import com.sanchelo.dummy.presentation.core.loginTextGradientColor

@OptIn(ExperimentalTextApi::class)
@Composable
fun LoginText(

) {
    Text(
        modifier = Modifier,
        style = TextStyle(
            brush = loginTextGradientColor,
            //color = MaterialTheme.colorScheme.primary,
            fontSize = 52.sp,
            fontFamily = fontFamily,
        ),
        text = "Login")
}