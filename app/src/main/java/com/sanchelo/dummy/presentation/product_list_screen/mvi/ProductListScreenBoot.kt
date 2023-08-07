package com.sanchelo.dummy.presentation.product_list_screen.mvi

import com.sanchelo.dummy.core.mvi.MviBoot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.sanchelo.dummy.presentation.product_list_screen.mvi.model.ProductListScreenEffects

object ProductListScreenBoot : MviBoot<ProductListScreenEffects> {

    override fun invoke(): Flow<ProductListScreenEffects> = flow {
        emit(ProductListScreenEffects.SelectNumber(number = 33))
    }
}
