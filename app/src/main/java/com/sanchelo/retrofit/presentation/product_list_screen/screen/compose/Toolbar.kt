package com.sanchelo.retrofit.presentation.product_list_screen.screen.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MenuButton(
    onMenuButtonClick: () -> Unit
) {
    IconButton(onClick = { onMenuButtonClick() }) {
        Icon(Icons.Outlined.Menu, contentDescription = "")
    }
}

@Composable
fun SearchButton(
    onSearchButtonClick: () -> Unit
) {
    IconButton(onClick = { onSearchButtonClick() }) {
        Icon(Icons.Outlined.Search, contentDescription = "")
    }
}

@Composable
fun FilterButton(
    onFilterButtonClick: () -> Unit
) {
    IconButton(onClick = { onFilterButtonClick() }) {
        Icon(Icons.Outlined.List, contentDescription = "")
    }
}