package com.sanchelo.dummy.presentation.main_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sanchelo.dummy.presentation.core.backgroundGradient
import com.sanchelo.dummy.presentation.main_screen.events.MainScreenEvents
import com.sanchelo.dummy.presentation.main_screen.screen.components.FilterButton
import com.sanchelo.dummy.presentation.main_screen.screen.components.MenuButton
import com.sanchelo.dummy.presentation.main_screen.screen.components.PostCard
import com.sanchelo.dummy.presentation.main_screen.screen.components.ProductCard
import com.sanchelo.dummy.presentation.main_screen.screen.components.SearchButton
import com.sanchelo.dummy.presentation.main_screen.view_model.MainScreenViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MainScreen(
    navigateToDetailScreen: () -> Unit,
) {
    val viewModel: MainScreenViewModel = hiltViewModel()

    val productCardState by viewModel.productCardState.collectAsStateWithLifecycle()
    val postCardState by viewModel.postCardState.collectAsStateWithLifecycle()

    val topAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    if (productCardState.isLoading && postCardState.isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LinearProgressIndicator(
                modifier = Modifier
            )
        }
    } else {
        Scaffold(
            modifier = Modifier
                .background(backgroundGradient)
                .fillMaxSize()
                .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = { },
                    navigationIcon = {  },
                    actions = {
                        SearchButton(onSearchButtonClick = {})
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
                        checkedStatus = postCardState.isLikeChecked,
                        onExpandClick = { viewModel.onEvent(MainScreenEvents.ExpandPostCardClick) },
                        expandState = postCardState.expanded
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
                        onCardClicked = {
                            navigateToDetailScreen()
                            viewModel.onEvent(MainScreenEvents.CardClick(item.id))
                        },
                        favoritesCheckedStatus = productCardState.isAddToFavoritesChecked.contains(
                            item.id
                        ),
                        onAddToFavoritesClick = {
                            viewModel.onEvent(
                                MainScreenEvents.AddToFavorites(
                                    item.id
                                )
                            )
                        },
                        cartCheckedStatus = productCardState.isAddToCartChecked.contains(item.id),
                        onAddToCartClick = { viewModel.onEvent(MainScreenEvents.AddToCart(item.id)) }
                    )
                }
            }
        }
    }
}
