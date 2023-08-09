package com.sanchelo.dummy.presentation.main_screen.mvvm.states

import com.sanchelo.dummy.domain.model.ProductData

data class ProductCardState(
    val productData: List<ProductData> = emptyList(),
    val isAddToFavoritesChecked: Boolean = false,
    val isAddToCartChecked: Boolean = false,
    val cardId: List<Int> = emptyList(),
    val isLoading: Boolean = false,
)
