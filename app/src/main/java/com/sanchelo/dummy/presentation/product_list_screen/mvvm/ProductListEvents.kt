package com.sanchelo.dummy.presentation.product_list_screen.mvvm

sealed class ProductListEvents {
    data object CardClick: ProductListEvents()
    data class AddToCart(val id: Int): ProductListEvents()
    data class AddToFavorites(val id: Int): ProductListEvents()
}
