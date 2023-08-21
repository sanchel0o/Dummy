package com.sanchelo.dummy.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun Animations() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    var sizeState by remember { mutableStateOf(200.dp) }
    var isRound by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(onClick = {
            isVisible = !isVisible
            isRound = !isRound
        }) {
            Text(text = "Toggle")
        }


//        AnimatedVisibility(
//            visible = isVisible,
//            enter = slideInHorizontally() + fadeIn(),
//
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(1f)
//        ) {
//            Box(modifier = Modifier.background(backgroundGradient))
//        }
    }
}