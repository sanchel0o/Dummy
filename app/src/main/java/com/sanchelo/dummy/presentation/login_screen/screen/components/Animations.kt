package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import kotlinx.coroutines.delay

@Composable
fun LoginScreenAnimation(
    content: @Composable () -> Unit) {

    var visible by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = visible) {
        visible = true
    }
    AnimatedVisibility(
        visible = visible,
        enter = expandVertically()
    ) {
        content()
    }
}