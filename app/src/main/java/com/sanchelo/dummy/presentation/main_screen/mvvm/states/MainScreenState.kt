package com.sanchelo.dummy.presentation.main_screen.mvvm.states

import com.sanchelo.dummy.domain.model.PostData
import com.sanchelo.dummy.domain.model.ProductData

data class MainScreenState(
    var productData: List<ProductData> = emptyList(),
    val postData: PostData? = null,
    val isLoading: Boolean = false,
)
