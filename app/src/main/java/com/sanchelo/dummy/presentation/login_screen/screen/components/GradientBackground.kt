package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sanchelo.dummy.presentation.core.backgroundGradientDark
import com.sanchelo.dummy.presentation.core.backgroundGradientLight

@Composable
fun GradientBackground(content: @Composable () -> Unit) {

    val backgroundColor = if(isSystemInDarkTheme()) backgroundGradientDark else backgroundGradientLight
    Box(modifier = Modifier
        .fillMaxSize()
        .background(backgroundColor)
    ) {
        content()
    }
}