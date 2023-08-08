package com.sanchelo.dummy.presentation.main_screen.mvvm.view_models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanchelo.dummy.domain.repository.ProductsRepository
import com.sanchelo.dummy.domain.use_cases.GetProductDataUseCase
import com.sanchelo.dummy.presentation.main_screen.mvvm.events.MainScreenEvents
import com.sanchelo.dummy.presentation.main_screen.mvvm.states.MainScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val productsRepository: ProductsRepository,

    private val getProductDataUseCase: GetProductDataUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenState())
    val uiState: StateFlow<MainScreenState> = _uiState.asStateFlow()

    fun onEvent(event: MainScreenEvents) {
        when (event) {
            is MainScreenEvents.AddToCart -> {
                Log.e("AAA", "Add to cart button clicked!")
            }

            is MainScreenEvents.AddToFavorites -> {
                Log.e("AAA", "Add to favorites button clicked!")
            }

            is MainScreenEvents.CardClick -> {
                Log.e("AAA", "Card clicked!")
            }

            is MainScreenEvents.ReactionClick -> {
                _uiState.value.postData?.reactions?.inc()
                Log.e("AAA", "Like Clicked!")
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

                value = _uiState.value.copy(
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
