package com.sanchelo.dummy.presentation.detail_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.sanchelo.dummy.presentation.main_screen.screen.components.FilterButton
import com.sanchelo.dummy.presentation.navigation.MainScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun DetailScreen(
    navController: NavController,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(MainScreens.MainScreen.route)
                        navController.popBackStack()
                    }
                    ) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
                    }
                },
                actions = {
                    FilterButton(onFilterButtonClick = {})
                },
                //scrollBehavior = topAppBarScrollBehavior
            )
        }
    ) { values ->
        Box(modifier = Modifier.padding(values)) {
            Text(text = "This is detail screen")
        }
    }
}

@Composable
fun BackButton(
    onBackClick: () -> Unit
) {
    IconButton(onClick = { onBackClick() }) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go Back")
    }
}