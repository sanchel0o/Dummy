package com.sanchelo.retrofit.presentation.product_list_screen.mvi.model

import com.sanchelo.retrofit.core.mvi.MviState

data class ProductListScreenState(
    val number: Int
) : MviState {

    companion object {
        val DEFAULT = ProductListScreenState(0)
    }
}
