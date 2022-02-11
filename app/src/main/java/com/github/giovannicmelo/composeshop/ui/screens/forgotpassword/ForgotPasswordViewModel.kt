package com.github.giovannicmelo.composeshop.ui.screens.forgotpassword

import androidx.core.util.PatternsCompat
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor() : ViewModel() {

    val email = MutableLiveData("")

    val state = MediatorLiveData<ForgotPasswordState>().apply {
        addSource(email) {
            val emailState = ForgotPasswordState()
            if (it.isNotBlank()) {
                value = if (validateEmail(it)) emailState.success() else emailState.error()
            }
        }
    }

    private fun validateEmail(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }
}