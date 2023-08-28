package com.sanchelo.dummy.domain.use_cases

import java.util.regex.Pattern

interface ValidateEmailUseCase {
    fun invoke(email: String): Boolean
}

class ValidateEmailUseCaseImpl(): ValidateEmailUseCase {

    val emailPattern = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$"
    )
    override fun invoke(email: String): Boolean {
        val matcher = emailPattern.matcher(email)
        return matcher.matches()
    }

}
