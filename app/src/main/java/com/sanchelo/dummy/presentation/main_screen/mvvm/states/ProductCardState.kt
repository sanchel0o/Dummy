package com.sanchelo.dummy.presentation.main_screen.mvvm.states

import com.sanchelo.dummy.domain.model.ProductData

data class ProductCardState(
    val productData: List<ProductData> = emptyList(),
    val isAddToFavoritesChecked: List<Int> = emptyList(),
    val isAddToCartChecked: Boolean = false,
    val cardId: Int = 0,
    val isLoading: Boolean = false,
)
