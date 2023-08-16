package com.sanchelo.dummy.presentation.login_screen

data class LoginScreenState(
    val login: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val loggedIn: Boolean = false
)
