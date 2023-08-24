package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sanchelo.dummy.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DummyImage(
    enabled: Boolean = false
) {

    var visible by remember {
        mutableStateOf(enabled)
    }

    LaunchedEffect(key1 = visible) {
        visible = true
    }

    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            animationSpec = spring(dampingRatio = 0.2f, stiffness = 100f),
            //initialOffsetY = { fullHeight -> fullHeight / 2 }
        ) + fadeIn(),
        exit = fadeOut(),
    ) {
        Image(
            modifier = Modifier
                .size(200.dp, 200.dp)
                .animateContentSize(
                    spring(dampingRatio = 0.1f, stiffness = 50f)
                ),

            painter = painterResource(id = R.drawable.topbar_logo),
            contentDescription = ""
        )
    }
}
