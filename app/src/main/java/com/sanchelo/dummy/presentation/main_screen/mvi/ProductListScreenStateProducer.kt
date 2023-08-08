package com.sanchelo.dummy.presentation.main_screen.mvi

import com.sanchelo.dummy.core.mvi.MviStateProducer
import com.sanchelo.dummy.presentation.main_screen.mvi.model.ProductListScreenEffects
import com.sanchelo.dummy.presentation.main_screen.mvi.model.ProductListScreenState

object ProductListScreenStateProducer : MviStateProducer<ProductListScreenEffects, ProductListScreenState> {
    override suspend fun invoke(
        effect: ProductListScreenEffects,
        previousState: ProductListScreenState
    ): ProductListScreenState = when (effect) {
        is ProductListScreenEffects.SelectNumber -> previousState.copy(number = effect.number)
        else -> previousState
    }
}
