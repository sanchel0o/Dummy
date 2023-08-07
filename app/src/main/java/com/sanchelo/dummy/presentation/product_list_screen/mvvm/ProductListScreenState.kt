package com.sanchelo.dummy.presentation.product_list_screen.mvvm

import com.sanchelo.dummy.domain.model.ProductData

data class ProductListScreenState(
    var productData: List<ProductData> = emptyList(),
    val isLoading: Boolean = false,
)
