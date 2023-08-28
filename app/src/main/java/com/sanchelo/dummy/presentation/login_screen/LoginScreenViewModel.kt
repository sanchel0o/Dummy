package com.sanchelo.dummy.presentation.login_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanchelo.dummy.domain.repository.DummyRemoteRepository
import com.sanchelo.dummy.presentation.login_screen.events.LoginScreenEvents
import com.sanchelo.dummy.presentation.login_screen.state.LoginScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
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
                    val result = try {
                        repository.authRequest(username, password)
                    } catch (ex: IOException) {
                        Log.e("AAA", ex.message.toString())
                        null
                    } catch (e: HttpException) {
                        Log.e("AAA", "HTTP error occurred with status code: ${e.code()}")
                        null
                    }
                }
            }

            is LoginScreenEvents.OnRememberMeCheckedChange -> {
                _loginScreenState.value = _loginScreenState.value.copy(
                    rememberMeChecked = !_loginScreenState.value.rememberMeChecked
                )
            }
        }
    }
}
