package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sanchelo.dummy.R

@Composable
fun DummyImage() {
    DummyImageAnimation {
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
