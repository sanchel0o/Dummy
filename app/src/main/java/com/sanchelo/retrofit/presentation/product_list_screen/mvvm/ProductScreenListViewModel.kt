package com.sanchelo.retrofit.presentation.product_list_screen.mvvm

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanchelo.retrofit.domain.model.ProductData
import com.sanchelo.retrofit.domain.repository.ProductsRepository
import com.sanchelo.retrofit.domain.use_cases.GetProductDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductScreenListViewModel @Inject constructor(
    private val repository: ProductsRepository,
    private val getProductDataUseCase: GetProductDataUseCase
) : ViewModel() {

    private var result: List<ProductData> = emptyList()

    private val _productData: MutableStateFlow<List<ProductData>> = MutableStateFlow(emptyList())
    val productData = _productData.asStateFlow()

    private val _titleInputFlow = MutableStateFlow("")
    val titleInputFlow: StateFlow<String> = _titleInputFlow.asStateFlow()

    fun getData() {
        viewModelScope.launch {
            result = repository.getProductsData()
            _productData.emit(result)
        }
    }

    init {
        getData()
        Log.e("AAA", "VM Created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM Destroyed")
        super.onCleared()
    }

}

