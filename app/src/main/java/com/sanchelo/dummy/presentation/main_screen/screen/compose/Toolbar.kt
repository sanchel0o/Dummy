package com.sanchelo.dummy.presentation.main_screen.screen.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sanchelo.dummy.R

@Composable
fun TopBarLogo() {
    Image(
        modifier = Modifier
            .size(width = 150.dp, height = 50.dp),
        contentScale = ContentScale.FillBounds,
        painter = painterResource(id = R.drawable.topbar_logo),
        contentDescription = "")
}

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