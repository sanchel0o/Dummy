package com.sanchelo.dummy.presentation.login_screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(): ViewModel() {

    private val _loginScreenState =  MutableStateFlow(LoginScreenState())
    val loginScreenState = _loginScreenState.asStateFlow()

    fun onEvent(event: LoginScreenEvents) {
        when(event) {
            is LoginScreenEvents.OnLoginChanged -> {
                _loginScreenState.value = _loginScreenState.value.copy(
                    login = event.login
                )
            }

            is LoginScreenEvents.OnPasswordChanged -> {
                _loginScreenState.value = _loginScreenState.value.copy(
                    password = event.password
                )
            }

            is LoginScreenEvents.OnLoginClick -> TODO()

        }
    }
    init {
    }

}