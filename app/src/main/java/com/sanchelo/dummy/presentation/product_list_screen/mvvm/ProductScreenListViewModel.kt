package com.sanchelo.dummy.presentation.product_list_screen.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private val productsRepository: ProductsRepository,

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

            is ProductListEvents.ReactionClick -> {

            }
        }
    }

    private fun getData() {
        viewModelScope.launch {
            with(_uiState) {
                value = value.copy(
                    productData = emptyList(),
                    postData = null,
                    isLoading = true
                )

                val products = try {
                    productsRepository.getProductsData()
                } catch (e: Exception) {

                    Log.e("AAA", "ERROR!")
                    emptyList()
                }

                val post = try {
                    productsRepository.getPost()
                } catch (e: Exception) {
                    value = value.copy(isLoading = false)
                    Log.e("AAA", "ERROR!")
                    null
                }

                _uiState.value = _uiState.value.copy(
                    productData = products,
                    postData = post,
                    isLoading = false
                )
            }
        }
    }

    init {
        getData()
    }
}
