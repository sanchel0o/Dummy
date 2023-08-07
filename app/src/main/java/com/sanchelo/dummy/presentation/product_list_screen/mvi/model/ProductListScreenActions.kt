package com.sanchelo.dummy.presentation.product_list_screen.mvi.model

import com.sanchelo.dummy.core.mvi.MviAction

sealed interface ProductListScreenActions : MviAction {
    object ClickCloseButton : ProductListScreenActions
    data class SelectNumber(val number: Int) : ProductListScreenActions
    object ClickAddToCartButton : ProductListScreenActions
    object ClickAddToFavoritesButton : ProductListScreenActions

}
