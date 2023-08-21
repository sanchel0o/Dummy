package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sanchelo.dummy.R

@Composable
fun DummyImage() {
    Image(
        modifier = Modifier.size(250.dp),
        painter = painterResource(id = R.drawable.splash_logo),
        contentDescription = "")

}