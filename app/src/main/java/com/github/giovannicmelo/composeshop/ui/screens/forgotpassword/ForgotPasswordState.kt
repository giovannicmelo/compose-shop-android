package com.github.giovannicmelo.composeshop.ui.screens.forgotpassword

data class ForgotPasswordState(
    val isValid: Boolean? = null,
    val errorMessage: String? = null,
) {
    fun error() = copy(
        isValid = false,
        errorMessage = "Not a valid email address.",
    )

    fun success() = copy(
        isValid = true,
        errorMessage = null,
    )
}