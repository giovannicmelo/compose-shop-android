package com.github.giovannicmelo.composeshop.ui.screens.login

import androidx.core.util.PatternsCompat
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    val email = MutableLiveData("")
    val password = MutableLiveData("")

    val loginValid = MediatorLiveData<Boolean>().apply {
        addSource(email) {
            value = validateEmail(it) && validatePassword(password.value.toString())
        }
        addSource(password) {
            value = validateEmail(email.value.toString()) && validatePassword(it)
        }
    }

    val emailValid = MediatorLiveData<Boolean>().apply {
        addSource(email) {
            if (it.isNotBlank()) {
                value = validateEmail(it)
            }
        }
    }

    val passwordValid = MediatorLiveData<Boolean>().apply {
        addSource(password) {
            if (it.isNotBlank()) {
                value = validatePassword(it)
            }
        }
    }

    private fun validateEmail(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validatePassword(password: String): Boolean {
        return password.length > 3
    }
}