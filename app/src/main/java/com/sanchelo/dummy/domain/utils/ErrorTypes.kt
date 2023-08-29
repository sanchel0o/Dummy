package com.sanchelo.dummy.domain.utils

sealed class ErrorTypes {
    data object NoNetworkConnections : ErrorTypes()
    data object AnotherSpecificError : ErrorTypes()
    data class GeneralError(val message: String?) : ErrorTypes()
}
