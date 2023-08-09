package com.sanchelo.dummy.presentation.main_screen.screen

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.sanchelo.dummy.presentation.main_screen.mvvm.events.MainScreenEvents
import com.sanchelo.dummy.presentation.main_screen.mvvm.view_models.MainScreenViewModel
import com.sanchelo.dummy.presentation.main_screen.screen.compose.FilterButton
import com.sanchelo.dummy.presentation.main_screen.screen.compose.MenuButton
import com.sanchelo.dummy.presentation.main_screen.screen.compose.PostCard
import com.sanchelo.dummy.presentation.main_screen.screen.compose.ProductCard
import com.sanchelo.dummy.presentation.main_screen.screen.compose.SearchButton
import androidx.compose.foundation.layout.fillMaxSize as fillMaxSize1

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MainScreen() {
    val viewModel: MainScreenViewModel = hiltViewModel()
    val productCardState by viewModel.productCardState.collectAsStateWithLifecycle()
    val postCardState by viewModel.postCardState.collectAsStateWithLifecycle()

    val topAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    if (productCardState.isLoading && postCardState.isLoading) {
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
                        title = postCardState.postData?.title ?: "No post",
                        body = postCardState.postData?.body ?: "Post body",
                        reactions = postCardState.postData?.reactions ?: 0,
                        tags = postCardState.postData?.tags ?: emptyList(),
                        onLikeClick = { viewModel.onEvent(MainScreenEvents.ReactionClick) },
                        checkedStatus = postCardState.isLikeChecked
                    )
                }
                itemsIndexed(
                    items = productCardState.productData
                ) { index, item ->
                    ProductCard(
                        cardId = item.id,
                        title = item.title,
                        brand = item.brand,
                        imageUrl = item.images[0],
                        price = item.price,
                        description = item.description,
                        onCardClicked = { viewModel.onEvent(MainScreenEvents.CardClick(index)) },
                        favoritesCheckedStatus = productCardState.isAddToFavoritesChecked.contains(item.id),
                        onAddToFavoritesClick = { viewModel.onEvent(MainScreenEvents.AddToFavorites(item.id)) }
                    )
                }
            }
//                items(
//                    items = productCardState.productData,
//                    key = { it.id }
//                ) { item ->
//                    ProductCard(
//                        cardId = item.id,
//                        title = item.title,
//                        brand = item.brand,
//                        imageUrl = item.images[0],
//                        price = item.price,
//                        description = item.description,
//                        onClicked = { viewModel.onEvent(MainScreenEvents.CardClick) },
//                        favoritesCheckedStatus = productCardState.isAddToFavoritesChecked,
//                        onAddToFavoritesClick = { viewModel.onEvent(MainScreenEvents.AddToFavorites) }
//                    )
//                } //       }
        }
    }
}
