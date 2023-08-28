package com.sanchelo.dummy.presentation.login_screen.events

sealed class LoginScreenEvents {
    data object OnLoginClick: LoginScreenEvents()
    class OnLoginChanged(val login: String): LoginScreenEvents()
    class OnPasswordChanged(val password: String): LoginScreenEvents()
    data object OnRememberMeCheckedChange: LoginScreenEvents()
}
