package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    labelValue: String,
    value: String,
    onValueChange: (String) -> Unit,
    errorStatus: Boolean = false
) {
    val passwordVisible by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(40.dp).padding(start = 16.dp),
            imageVector = Icons.Outlined.Lock,
            tint = MaterialTheme.colorScheme.outline,
            contentDescription = "")
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            label = { Text(text = labelValue) },
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.surface,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.outline,
                unfocusedLabelColor = MaterialTheme.colorScheme.outline
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            value = value,
            onValueChange = { onValueChange(it) },
            isError = errorStatus,
        )
    }
}
