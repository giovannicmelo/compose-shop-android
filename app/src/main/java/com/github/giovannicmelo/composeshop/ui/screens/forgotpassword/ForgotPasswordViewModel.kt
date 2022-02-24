package com.github.giovannicmelo.composeshop.ui.screens.forgotpassword

import androidx.core.util.PatternsCompat
import androidx.lifecycle.ViewModel
import com.github.giovannicmelo.composeshop.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<String>>(UiState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _state = MutableStateFlow(DataState())
    val state = _state.asStateFlow()
    fun setEmail(text: String) = _state.update { it.copy(email = text) }

    fun validateEmail(): Boolean? {
        return if (_state.value.email.isNotEmpty())
            PatternsCompat.EMAIL_ADDRESS.matcher(_state.value.email).matches()
        else null
    }

    data class DataState(
        val email: String = ""
    )
}