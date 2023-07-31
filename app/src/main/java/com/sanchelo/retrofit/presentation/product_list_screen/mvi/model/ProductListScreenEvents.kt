package com.sanchelo.retrofit.presentation.product_list_screen.mvi.model

import com.sanchelo.retrofit.core.mvi.MviEvent

sealed interface ProductListScreenEvents : MviEvent {
    object CloseApp : ProductListScreenEvents
}
