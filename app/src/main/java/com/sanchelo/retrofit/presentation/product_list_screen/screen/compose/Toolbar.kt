package com.sanchelo.retrofit.presentation.product_list_screen.screen.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun Toolbar() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = {
                Text(text = "Toolbar")
            })
        }
    ) {values ->
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(values)
        ){
            items(10) {
                Text(
                    text = "Item $it",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        
    }    
}