package com.sanchelo.retrofit.presentation.product_list_screen.mvi

import com.sanchelo.retrofit.core.mvi.MviEventProducer
import com.sanchelo.retrofit.presentation.product_list_screen.mvi.model.ProductListScreenEffects
import com.sanchelo.retrofit.presentation.product_list_screen.mvi.model.ProductListScreenEvents

object ProductListScreenEventProducer : MviEventProducer<ProductListScreenEffects, ProductListScreenEvents> {

    override suspend fun invoke(effect: ProductListScreenEffects): ProductListScreenEvents? = when (effect) {
        is ProductListScreenEffects.CloseApp -> ProductListScreenEvents.CloseApp
        else -> null
    }
}
