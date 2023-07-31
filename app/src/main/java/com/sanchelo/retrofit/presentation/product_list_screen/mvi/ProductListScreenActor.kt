package com.sanchelo.retrofit.presentation.product_list_screen.mvi

import com.sanchelo.retrofit.core.mvi.MviActor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.sanchelo.retrofit.presentation.product_list_screen.mvi.model.ProductListScreenActions
import com.sanchelo.retrofit.presentation.product_list_screen.mvi.model.ProductListScreenEffects
import com.sanchelo.retrofit.presentation.product_list_screen.mvi.model.ProductListScreenState

object ProductListScreenActor : MviActor<ProductListScreenActions, ProductListScreenEffects, ProductListScreenState> {

    override suspend fun invoke(
        action: ProductListScreenActions,
        state: ProductListScreenState
    ): Flow<ProductListScreenEffects> = flow {
        when (action) {
//            is ProductListScreenActions.ClickCloseButton ->
//                emit(ProductListScreenEffects.CloseApp)
//
//            is ProductListScreenActions.SelectNumber ->
//                emit(ProductListScreenEffects.SelectNumber(number = action.number))

            else -> {}
        }
    }
}
