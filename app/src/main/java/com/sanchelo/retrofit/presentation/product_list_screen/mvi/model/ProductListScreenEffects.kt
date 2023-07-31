package com.sanchelo.retrofit.presentation.product_list_screen.mvi.model

import com.sanchelo.retrofit.core.mvi.MviEffect

sealed interface ProductListScreenEffects : MviEffect {
    object CloseApp : ProductListScreenEffects
    data class SelectNumber(val number: Int) : ProductListScreenEffects
}
