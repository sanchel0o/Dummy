package com.sanchelo.dummy.presentation.product_list_screen.mvi

import com.sanchelo.dummy.core.mvi.MviEventProducer
import com.sanchelo.dummy.presentation.product_list_screen.mvi.model.ProductListScreenEffects
import com.sanchelo.dummy.presentation.product_list_screen.mvi.model.ProductListScreenEvents

object ProductListScreenEventProducer : MviEventProducer<ProductListScreenEffects, ProductListScreenEvents> {

    override suspend fun invoke(effect: ProductListScreenEffects): ProductListScreenEvents? = when (effect) {
        is ProductListScreenEffects.CloseApp -> ProductListScreenEvents.CloseApp
        else -> null
    }
}
