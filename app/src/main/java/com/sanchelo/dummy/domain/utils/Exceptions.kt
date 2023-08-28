package com.sanchelo.dummy.domain.utils

sealed class Exceptions(message: String? = null): Exception(message) {
    data object NoNetworkConnectionException: Exceptions()
    data object AnotherScpecificException: Exceptions()

    fun mapToCustonError(): ErrorTypes = when(this) {
        is NoNetworkConnectionException -> {
            ErrorTypes.NoNetworkConnections
        }

        is AnotherScpecificException -> {
            ErrorTypes.AnotherSpecificError
        }

        else -> ErrorTypes.GeneralError(this.message)
    }
}
