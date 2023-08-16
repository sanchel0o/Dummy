package com.sanchelo.dummy.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.sanchelo.dummy.auth.utils.await
import com.sanchelo.dummy.data.model.remote.UserDto

class AuthRepositoryImpl(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    override suspend fun login(email: String, password: String): FirebaseUser = try {
        firebaseAuth.signInWithEmailAndPassword(email, password).await().user!!
    } catch (e: Exception) {
        e.printStackTrace()
        firebaseAuth.signInWithEmailAndPassword(email, password).await().user!!
    }



    override suspend fun signUp(name: String, email: String, password: String): FirebaseUser {
        TODO("Not yet implemented")
    }

    override fun logUout() {
        TODO("Not yet implemented")
    }

    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser
}
