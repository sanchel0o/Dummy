package com.sanchelo.dummy.presentation.main_screen.states

import com.sanchelo.dummy.domain.model.ProductData

data class ProductCardState(
    val productData: List<ProductData> = emptyList(),
    val isAddToFavoritesChecked: List<Int> = emptyList(),
    val isAddToCartChecked: List<Int> = emptyList(),
    val isLoading: Boolean = false,
)
