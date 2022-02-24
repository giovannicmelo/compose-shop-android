package com.github.giovannicmelo.composeshop.ui.screens.forgotpassword

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordActivity : ComponentActivity() {

    private val viewModel: ForgotPasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val uiState by viewModel.uiState.collectAsState()
            val state by viewModel.state.collectAsState()

            val activity: ComponentActivity = this

            ForgotPasswordScreen(
                email = state.email,
                isValidEmail = viewModel.validateEmail(),
                onEmailChanged = viewModel::setEmail,
                backButtonAction = { activity.finish() }
            )
        }
    }
}

