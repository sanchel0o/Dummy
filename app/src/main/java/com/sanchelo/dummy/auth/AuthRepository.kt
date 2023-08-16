package com.sanchelo.dummy.auth

import com.google.firebase.auth.FirebaseUser
import com.sanchelo.dummy.data.model.remote.UserDto

interface AuthRepository {
    suspend fun login(email: String, password: String): FirebaseUser
    suspend fun signUp(name: String, email: String, password: String): FirebaseUser

    val currentUser: FirebaseUser?
    fun logUout()
}