package com.sanchelo.retrofit.presentation.product_list_screen.mvvm

import com.sanchelo.retrofit.domain.model.ProductData

data class ProductListScreenState(
    var productData: List<ProductData> = emptyList(),
    val isLoading: Boolean = false,
)
