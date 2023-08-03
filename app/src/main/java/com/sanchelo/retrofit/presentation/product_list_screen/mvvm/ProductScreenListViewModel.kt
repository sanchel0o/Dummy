package com.sanchelo.retrofit.presentation.product_list_screen.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanchelo.retrofit.domain.model.ProductData
import com.sanchelo.retrofit.domain.repository.ProductsRepository
import com.sanchelo.retrofit.domain.use_cases.GetProductDataUseCase
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



    private val _productData: MutableStateFlow<List<ProductData>> = MutableStateFlow(emptyList())
    val productData = _productData.asStateFlow()

    private val _uiState = MutableStateFlow(ProductListScreenState())
    val uiState: StateFlow<ProductListScreenState> = _uiState.asStateFlow()

    fun onEvent(event: ProductListEvents) {
        when(event) {
            is ProductListEvents.AddToCart -> {
                Log.e("AAA","Add to cart button clicked!")
            }
            is ProductListEvents.AddToFavorites -> {
                Log.e("AAA","Add to favorites button clicked!")
            }
            is ProductListEvents.CardClick -> {
                Log.e("AAA","Card clicked!")
            }
        }
    }
    private fun getData() {
        viewModelScope.launch {
            _productData.emit(repository.getProductsData())
        }
    }

    fun onCardClick() {

    }

    init {
        if (_productData.value.isEmpty()) {
            getData()
            Log.e("AAA", "VM Created")
        }
    }
}
