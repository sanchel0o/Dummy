package com.sanchelo.dummy.presentation.product_list_screen.mvi.model

import com.sanchelo.dummy.core.mvi.MviEffect

sealed interface ProductListScreenEffects : MviEffect {
    object CloseApp : ProductListScreenEffects
    data class SelectNumber(val number: Int) : ProductListScreenEffects
}