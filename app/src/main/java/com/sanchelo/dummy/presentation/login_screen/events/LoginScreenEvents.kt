package com.sanchelo.dummy.presentation.login_screen.events

sealed class LoginScreenEvents {
    data object loginClick: LoginScreenEvents()
}
