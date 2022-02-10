package com.github.giovannicmelo.composeshop.ui.screens

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
            value = validateLogin(it, password.value.toString())
        }
        addSource(password) {
            value = validateLogin(email.value.toString(), it)
        }
    }

    private fun validateLogin(email: String, password: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches() && password.length > 3
    }
}