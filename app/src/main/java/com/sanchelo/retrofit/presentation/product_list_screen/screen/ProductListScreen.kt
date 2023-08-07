package com.sanchelo.retrofit.presentation.product_list_screen.screen

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sanchelo.retrofit.presentation.product_list_screen.mvvm.ProductListEvents
import com.sanchelo.retrofit.presentation.product_list_screen.mvvm.ProductScreenListViewModel
import com.sanchelo.retrofit.presentation.product_list_screen.screen.compose.FilterButton
import com.sanchelo.retrofit.presentation.product_list_screen.screen.compose.MenuButton
import com.sanchelo.retrofit.presentation.product_list_screen.screen.compose.ProductCard
import com.sanchelo.retrofit.presentation.product_list_screen.screen.compose.SearchButton
import com.sanchelo.retrofit.presentation.product_list_screen.screen.compose.TopBarLogo

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ProductListScreen() {
    val viewModel: ProductScreenListViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    val topAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { TopBarLogo() },
                navigationIcon = { MenuButton(onMenuButtonClick = {}) },
                actions = {
                    SearchButton(onSearchButtonClick = {})
                    FilterButton(onFilterButtonClick = {})
                },
                scrollBehavior = topAppBarScrollBehavior
            )
        }) { values ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .consumeWindowInsets(values),
            contentPadding = values
        ) {
            items(
                items = state.productData,
                key = { it.id }
            ) { item ->
                ProductCard(
                    title = item.title,
                    brand = item.brand,
                    imageUrl = item.images[0],
                    price = item.price,
                    description = item.description,
                    onClicked = { viewModel.onEvent(ProductListEvents.CardClick) }
                )
            }
        }
    }
}
