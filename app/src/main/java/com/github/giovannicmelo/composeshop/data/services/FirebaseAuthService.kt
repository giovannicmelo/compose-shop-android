package com.github.giovannicmelo.composeshop.data.services

import com.github.giovannicmelo.composeshop.data.ResultWrapper
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthService @Inject constructor(private val auth: FirebaseAuth) {

    suspend fun signIn(email: String, password: String): ResultWrapper<AuthResult> {
        return requestApiCall(Dispatchers.IO) {
            auth.signInWithEmailAndPassword(email, password).await()
        }
    }
}