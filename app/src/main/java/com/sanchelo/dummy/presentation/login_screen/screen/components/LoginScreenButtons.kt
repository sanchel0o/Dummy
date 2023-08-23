package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.sanchelo.dummy.presentation.core.VioletBlue

@Composable
fun RememberMeButton() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.primary,
                uncheckedColor = VioletBlue
            ),
            checked = false,
            onCheckedChange = {},
        )
        Text(
            style = TextStyle(
                color = VioletBlue
            ),
            text = "Remember me"
        )
    }
}

@Composable
fun LoginButton(
    label: String,
    onLoginButtonClicked: () -> Unit,
    isLoginButtonEnabled: Boolean
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 24.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(5.dp)),
        onClick = { onLoginButtonClicked() }
    ) {
        Text(text = label)
    }
}

@Composable
fun ForgetPasswordButton() {
    TextButton(
        onClick = {}
    ) {
        Text(text = "Forget password?")
    }
}