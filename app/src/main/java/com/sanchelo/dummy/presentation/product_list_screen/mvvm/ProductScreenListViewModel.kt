package com.sanchelo.dummy.presentation.product_list_screen.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanchelo.dummy.domain.model.ProductData
import com.sanchelo.dummy.domain.repository.ProductsRepository
import com.sanchelo.dummy.domain.use_cases.GetProductDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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
                val isPressed = true
                Log.e("AAA", "Add to favorites button clicked!")
            }

            is ProductListEvents.CardClick -> {
                
                Log.e("AAA", "Card clicked!")
            }
        }
    }

    private fun getData() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                productData = emptyList(),
                isLoading = true
            )

            val response: List<ProductData> = try {
                repository.getProductsData()
            } catch (e: Exception) {
                emptyList()
            }

            _uiState.value = _uiState.value.copy(
                productData = response,
                isLoading = false
            )
        }
    }

    init {
        if (uiState.value.productData.isEmpty()) {
            getData()
            Log.e("AAA", "VM Created")
        }
    }
}
