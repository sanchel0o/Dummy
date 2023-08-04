package com.sanchelo.retrofit.presentation.product_list_screen.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanchelo.retrofit.domain.model.ProductData
import com.sanchelo.retrofit.domain.repository.ProductsRepository
import com.sanchelo.retrofit.domain.use_cases.GetProductDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductScreenListViewModel @Inject constructor(
    private val repository: ProductsRepository,
    private val getProductDataUseCase: GetProductDataUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductListScreenState())
    val uiState: StateFlow<ProductListScreenState> = _uiState.asStateFlow()

    fun onEvent(event: ProductListEvents) {
        when (event) {
            is ProductListEvents.AddToCart -> {
                Log.e("AAA", "Add to cart button clicked!")
            }

            is ProductListEvents.AddToFavorites -> {
                Log.e("AAA", "Add to favorites button clicked!")
            }

            is ProductListEvents.CardClick -> {
                Log.e("AAA", "Card clicked!")
            }
        }
    }

    private fun getData() {
        viewModelScope.launch {
            val response: List<ProductData> = try {
                Log.e("UIFlow", "Data Loaded")
                repository.getProductsData()
            } catch ( e:Exception ) {
                emptyList()
            }
            _uiState.value = _uiState.value.copy( productData = response)
        }
    }
    init {
        if (uiState.value.productData.isEmpty()) {
            getData()
            Log.e("AAA", "VM Created")
        }
    }
}
