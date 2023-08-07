package com.sanchelo.dummy.presentation.product_list_screen.mvi.model

import com.sanchelo.dummy.core.mvi.MviState

data class ProductListScreenState(
    val number: Int
) : MviState {

    companion object {
        val DEFAULT = ProductListScreenState(0)
    }
}