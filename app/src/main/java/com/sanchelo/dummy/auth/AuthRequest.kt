package com.sanchelo.dummy.auth

import com.google.gson.annotations.SerializedName

data class AuthRequest(
    val username: String,
    val password: String
)
