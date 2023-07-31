package com.sanchelo.retrofit.presentation.product_list_screen.mvi

import com.sanchelo.retrofit.core.mvi.MviBoot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.sanchelo.retrofit.presentation.product_list_screen.mvi.model.ProductListScreenEffects

object ProductListScreenBoot : MviBoot<ProductListScreenEffects> {

    override fun invoke(): Flow<ProductListScreenEffects> = flow {
        emit(ProductListScreenEffects.SelectNumber(number = 33))
    }
}
