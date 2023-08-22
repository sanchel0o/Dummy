package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextField(
    labelValue: String,
    value: String,
    onValueChange: (String) -> Unit,
    errorStatus: Boolean = false
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(40.dp).padding(start = 16.dp),
            tint = MaterialTheme.colorScheme.outline,
            imageVector = Icons.Outlined.Person,
            contentDescription = ""
        )
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
            value = value,
            onValueChange = { onValueChange(it) },
            isError = errorStatus,
        )
    }
}
