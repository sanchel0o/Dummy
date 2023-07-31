package com.sanchelo.retrofit.presentation.product_list_screen.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanchelo.retrofit.domain.repository.ProductsRepository
import com.sanchelo.retrofit.domain.use_cases.GetProductDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductScreenListViewModel @Inject constructor(
    val repository: ProductsRepository
): ViewModel() {

    private var _state = MutableStateFlow(0)
    val state = _state.asStateFlow()

    fun incrementCounter() {
        _state.value += 1
    }

    init {
        Log.e("AAA", "VM Created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM Destroyed")
        super.onCleared()
    }

}

