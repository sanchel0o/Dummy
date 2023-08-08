package com.sanchelo.dummy.presentation.main_screen.mvi

import com.sanchelo.dummy.core.mvi.MviViewModel
import com.sanchelo.dummy.presentation.main_screen.mvi.model.ProductListScreenActions
import com.sanchelo.dummy.presentation.main_screen.mvi.model.ProductListScreenEffects
import com.sanchelo.dummy.presentation.main_screen.mvi.model.ProductListScreenEvents
import com.sanchelo.dummy.presentation.main_screen.mvi.model.ProductListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor() : MviViewModel
<ProductListScreenActions, ProductListScreenEffects, ProductListScreenEvents,ProductListScreenState>(
        defaultState = ProductListScreenState.DEFAULT,
        actor = ProductListScreenActor,
        boot = ProductListScreenBoot,
        eventProducer = ProductListScreenEventProducer,
        stateProducer = ProductListScreenStateProducer,
        tag = "MainScreen"
)