package com.sanchelo.dummy.presentation.product_list_screen.screen

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sanchelo.dummy.presentation.product_list_screen.mvvm.ProductListEvents
import com.sanchelo.dummy.presentation.product_list_screen.mvvm.ProductScreenListViewModel
import com.sanchelo.dummy.presentation.product_list_screen.screen.compose.FilterButton
import com.sanchelo.dummy.presentation.product_list_screen.screen.compose.MenuButton
import com.sanchelo.dummy.presentation.product_list_screen.screen.compose.PostCard
import com.sanchelo.dummy.presentation.product_list_screen.screen.compose.ProductCard
import com.sanchelo.dummy.presentation.product_list_screen.screen.compose.SearchButton
import androidx.compose.foundation.layout.fillMaxSize as fillMaxSize1

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MainScreen() {
    val viewModel: ProductScreenListViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    val topAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    if (state.isLoading) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
        )
    } else {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize1()
                    .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection),
                topBar = {
                    TopAppBar(
                        title = { },
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
                    item {
                        PostCard(
                            title = state.postData?.title ?: "No post",
                            body = state.postData?.body ?: "Post body",
                            reactions = state.postData?.reactions ?: 0,
                            tags = state.postData?.tags ?: emptyList()

                        )
                    }
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

}
