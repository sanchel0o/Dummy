package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun LoginButton(
    label: String,
    onLoginButtonClicked: () -> Unit,
    isLoginButtonEnabled: Boolean
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(5.dp)),
        onClick = { /*TODO*/ }
    ) {
        Text(text = label)
    }
}