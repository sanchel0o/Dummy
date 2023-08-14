package com.sanchelo.dummy.presentation.detail_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(): ViewModel() {

    init {
        Log.e("AAA", "VMD created!!")
    }

    override fun onCleared() {
        Log.e("AAA", "VMD destroyed!!")
        super.onCleared()
    }
}