package com.sanchelo.dummy.presentation.login_screen.utils

import com.sanchelo.dummy.domain.model.UserData

sealed class Resource {
    data class Success(val userData: UserData) : Resource()
    data class Error(val message: String, val cause: Exception? = null) : Resource()
}
