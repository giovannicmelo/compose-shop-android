package com.github.giovannicmelo.composeshop.ui.screens.login

import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.giovannicmelo.composeshop.data.ResultWrapper
import com.github.giovannicmelo.composeshop.data.services.FirebaseAuthService
import com.github.giovannicmelo.composeshop.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val service: FirebaseAuthService) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<String>>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _loginState = MutableStateFlow(DataState())
    val loginState = _loginState.asStateFlow()
    fun setEmail(text: String) = _loginState.update { it.copy(email = text) }
    fun setPassword(text: String) = _loginState.update { it.copy(password = text) }

    fun validateEmail(): Boolean? {
        return if (_loginState.value.email.isNotEmpty())
            PatternsCompat.EMAIL_ADDRESS.matcher(_loginState.value.email).matches()
        else null
    }

    fun validatePassword(): Boolean? {
        return if (_loginState.value.password.isNotEmpty())
            _loginState.value.password.length > 3
        else null
    }

    fun signIn() = viewModelScope.launch {
        val (email, pass) = _loginState.value
        _uiState.value = UiState.Loading
        when (val result = service.signIn(email, pass)) {
            is ResultWrapper.Success -> {
                _uiState.value = UiState.Success(result.data.user!!.uid)
            }
            is ResultWrapper.GenericError -> {
                _uiState.value = UiState.Failure(result.error?.message ?: "Unknown error")
            }
            is ResultWrapper.NetworkError -> {
                _uiState.value = UiState.Failure("No internet connection")
            }
        }
    }

    data class DataState(
        val email: String = "",
        val password: String = ""
    )
}
