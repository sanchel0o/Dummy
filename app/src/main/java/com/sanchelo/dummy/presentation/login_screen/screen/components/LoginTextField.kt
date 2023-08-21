package com.sanchelo.dummy.presentation.login_screen.screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextField(
    labelValue: String,
    value: String,
    onValueChange: (String) -> Unit,
    errorStatus: Boolean = false
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
            .height(64.dp),
        shape = RoundedCornerShape(24.dp),
        singleLine = true,
        maxLines = 1,
        label = { Text(text = labelValue) },
        isError = errorStatus,
        colors = TextFieldDefaults.outlinedTextFieldColors(

        ),

//        trailingIcon = {
//
//            val iconImage = if (passwordVisible.value) {
//                Icons.Filled.Visibility
//            } else {
//                Icons.Filled.VisibilityOff
//            }
//
//            val description = if (passwordVisible.value) {
//                stringResource(id = R.string.hide_password)
//            } else {
//                stringResource(id = R.string.show_password)
//            }
//
//            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
//                Icon(imageVector = iconImage, contentDescription = description)
//            }
//        },
        value = value,
        onValueChange = { onValueChange(it) }
    )
}