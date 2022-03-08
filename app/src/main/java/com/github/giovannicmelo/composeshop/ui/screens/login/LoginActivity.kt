package com.github.giovannicmelo.composeshop.ui.screens.login

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import com.github.giovannicmelo.composeshop.utils.Actions
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
@ExperimentalMaterialApi
class LoginActivity : ComponentActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current

            val uiState by viewModel.uiState.collectAsState()
            val loginState by viewModel.loginState.collectAsState()

            LoginScreen(
                uiState = uiState,
                dataState = loginState,
                isValidEmail = viewModel.validateEmail(),
                isValidPassword = viewModel.validatePassword(),
                onEmailChanged = viewModel::setEmail,
                onPasswordChanged = viewModel::setPassword,
                forgotPasswordAction = { gotoForgotPassword(context) },
                successAction = { gotoMain(context) },
                loginAction = viewModel::signIn
            )
        }
    }

    private fun gotoForgotPassword(context: Context) {
        val intent = Actions.ForgotPassword.Navigation.createIntent(context)
        startActivity(intent)
    }

    private fun gotoMain(context: Context) {
        val intent = Actions.Main.Navigation.createIntent(context)
        startActivity(intent)
    }
}