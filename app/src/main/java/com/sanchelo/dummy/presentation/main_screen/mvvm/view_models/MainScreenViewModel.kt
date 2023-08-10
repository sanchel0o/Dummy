package com.sanchelo.dummy.presentation.main_screen.mvvm.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanchelo.dummy.domain.repository.DummyRemoteRepository
import com.sanchelo.dummy.domain.use_cases.GetProductDataUseCase
import com.sanchelo.dummy.presentation.main_screen.mvvm.events.MainScreenEvents
import com.sanchelo.dummy.presentation.main_screen.mvvm.states.PostCardState
import com.sanchelo.dummy.presentation.main_screen.mvvm.states.ProductCardState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: DummyRemoteRepository,
    private val getProductDataUseCase: GetProductDataUseCase
) : ViewModel() {

    private val _productCardState = MutableStateFlow(ProductCardState())
    val productCardState: StateFlow<ProductCardState> = _productCardState.asStateFlow()

    private val _postCardState = MutableStateFlow(PostCardState())
    val postCardState: StateFlow<PostCardState> = _postCardState.asStateFlow()

    fun onEvent(event: MainScreenEvents) {
        when (event) {
            is MainScreenEvents.AddToCart -> {
                if (event.id in _productCardState.value.isAddToCartChecked) {
                    _productCardState.value = _productCardState.value.copy(
                        isAddToCartChecked = _productCardState
                            .value
                            .isAddToCartChecked
                            .toMutableList()
                            .also { it.remove(event.id) }
                    )
                } else {
                    _productCardState.value = _productCardState.value.copy(
                        isAddToCartChecked = _productCardState
                            .value
                            .isAddToCartChecked
                            .toMutableList()
                            .also { it.add(event.id) }
                    )
                }
            }

            is MainScreenEvents.AddToFavorites -> {
                if (event.id in _productCardState.value.isAddToFavoritesChecked) {
                    _productCardState.value = _productCardState.value.copy(
                        isAddToFavoritesChecked = _productCardState
                            .value
                            .isAddToFavoritesChecked
                            .toMutableList()
                            .also { it.remove(event.id) }
                    )
                } else {
                    _productCardState.value = _productCardState.value.copy(
                        isAddToFavoritesChecked = _productCardState
                            .value
                            .isAddToFavoritesChecked
                            .toMutableList()
                            .also { it.add(event.id) }
                    )
                }
            }

            is MainScreenEvents.CardClick -> {

            }

            is MainScreenEvents.ReactionClick -> {
                if (_postCardState.value.isLikeChecked) {
                    _postCardState.value.postData?.let { postData ->
                        _postCardState.value = _postCardState.value.copy(
                            postData = postData.copy(reactions = postData.reactions - 1),
                            isLikeChecked = false
                        )
                    }
                } else {
                    _postCardState.value.postData?.let { postData ->
                        _postCardState.value = _postCardState.value.copy(
                            postData = postData.copy(reactions = postData.reactions + 1),
                            isLikeChecked = true
                        )
                    }
                }
            }

            is MainScreenEvents.ExpandPostCardClick -> {
                if (_postCardState.value.expanded) {
                    _postCardState.value = _postCardState.value.copy(expanded = false)
                } else {
                    _postCardState.value = _postCardState.value.copy(expanded = true)
                }
            }
        }
    }

    private fun getPostData() {
        viewModelScope.launch {
            with (_postCardState) {
                value = value.copy(
                    postData = null,
                    isLoading = true,
                )

                val post = try {
                    repository.getPost()
                } catch (e: Exception) {
                    value = value.copy(isLoading = false)
                    null
                }

                value = value.copy(
                    postData = post,
                    isLoading = false
                )
            }
        }
    }

    private fun getProductsData() {
        viewModelScope.launch {
            with(_productCardState) {
                value = value.copy(
                    productData = emptyList(),
                    isLoading = true
                )

                val products = try {
                    repository.getProductsData()
                } catch (e: Exception) {
                    emptyList()
                }

                value = _productCardState.value.copy(
                    productData = products,
                    isLoading = false,
                )
            }
        }
    }

    init {
        getProductsData()
        getPostData()
    }
}
