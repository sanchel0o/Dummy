package com.sanchelo.dummy.presentation.login_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanchelo.dummy.auth.AuthRequest
import com.sanchelo.dummy.domain.repository.DummyRemoteRepository
import com.sanchelo.dummy.presentation.login_screen.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val repository: DummyRemoteRepository,
) : ViewModel() {

    private val _loginScreenState = MutableStateFlow(LoginScreenState())
    val loginScreenState = _loginScreenState.asStateFlow()

    fun onEvent(event: LoginScreenEvents) {
        when (event) {
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

            is LoginScreenEvents.OnLoginClick -> {
                val username = _loginScreenState.value.login
                val password = _loginScreenState.value.password
                viewModelScope.launch {
                    try {
                        val result = repository.authRequest(username, password)
                        Resource.Success(userData = result)
                    } catch (ex: IOException) {
                        Resource.Error(
                            message = "Error!!! ${ ex.message }",
                            cause = ex
                        )
                        Log.e("AAA", ex.message.toString())
                    }
                }
            }
        }
    }

    init {

    }

}