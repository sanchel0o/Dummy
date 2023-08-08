package com.sanchelo.dummy.presentation.main_screen.mvi.model

import com.sanchelo.dummy.core.mvi.MviEvent

sealed interface ProductListScreenEvents : MviEvent {
    object CloseApp : ProductListScreenEvents
}
