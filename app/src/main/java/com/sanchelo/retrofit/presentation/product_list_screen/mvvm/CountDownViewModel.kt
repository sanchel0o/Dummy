package com.sanchelo.retrofit.presentation.product_list_screen.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class CountDownViewModel : ViewModel() {

    private var _stateFlow = MutableStateFlow(0)
    val stateFlow = _stateFlow.asStateFlow()

    fun incrementCounter() {
        _stateFlow.value += 1
    }

    val countDownFlow = flow {
        val startVal = 5
        var currentVal = startVal
        while (currentVal > 0) {
            delay(1000L)
            emit(currentVal)
            currentVal--
        }
    }

    init {
        collectFlow()
    }

    private fun collectFlow() {
        val flow1 = flow {
            delay(250L)
            emit("Appetizer")
            delay(1000L)
            emit("Main dish")
            delay(100L)
            emit("Ice Cream")
        }

        viewModelScope.launch {
            flow1.onEach {
                println("#FLOW: $it is delivered")
            }
                .collectLatest {
                    println("#FLOW: Now eating $it")
                    delay(1500L)
                    println("#FLOW: Finished eating $it")
                }
        }
    }
}

