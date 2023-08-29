package com.sanchelo.dummy.presentation.main_screen.screen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun ProductCardAnimation(
    visibleStatus: Boolean,
    content: @Composable () -> Unit
) {

    var visible by remember {
        mutableStateOf(visibleStatus)
    }
    LaunchedEffect(key1 = visible) {
        visible = true
    }
    AnimatedVisibility(
        visible = visible, enter = slideInVertically(
            animationSpec = spring(dampingRatio = 0.8f, stiffness = 100f),
            initialOffsetY = { fullHeight -> fullHeight }
        ) + fadeIn()) {
        content()
    }
}