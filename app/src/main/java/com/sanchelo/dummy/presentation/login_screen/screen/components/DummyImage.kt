package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sanchelo.dummy.R

@Composable
fun DummyImage() {
    Image(
        modifier = Modifier.size(200.dp).animateContentSize(
            animationSpec = tween(durationMillis = 500, easing = LinearEasing)
        ),
        painter = painterResource(id = R.drawable.topbar_logo),
        contentDescription = "")

}