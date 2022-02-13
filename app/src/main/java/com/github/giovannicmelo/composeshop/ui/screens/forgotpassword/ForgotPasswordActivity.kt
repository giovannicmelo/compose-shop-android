package com.github.giovannicmelo.composeshop.ui.screens.forgotpassword

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.giovannicmelo.composeshop.R
import com.github.giovannicmelo.composeshop.ui.components.*
import com.github.giovannicmelo.composeshop.ui.theme.ComposeShopTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordActivity : ComponentActivity() {

    private val viewModel: ForgotPasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val email by viewModel.email.observeAsState()
            val emailValid by viewModel.emailValid.observeAsState()

            val activity: ComponentActivity = this

            ComposeForgotPasswordScreen(
                email = email ?: "",
                isValidEmail = emailValid ?: false,
                onEmailChanged = { viewModel.email.postValue(it) },
                backButtonAction = { activity.finish() }
            )
        }
    }
}

@Composable
fun ComposeForgotPasswordScreen(
    email: String,
    isValidEmail: Boolean,
    onEmailChanged: (String) -> Unit = {},
    backButtonAction: () -> Unit = {}
) {
    ComposeShopTheme {
        Scaffold(topBar = {
            TopAppBarWithBackButton(navAction = backButtonAction)
        }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Headline1Text(text = stringResource(R.string.title_activity_forgot_password))
                Spacer(modifier = Modifier.height(73.dp))
                DescriptiveText(text = stringResource(R.string.forgot_password_description))
                Spacer(modifier = Modifier.height(16.dp))
                EmailTextField(
                    text = email,
                    onChanged = onEmailChanged,
                    isValid = isValidEmail,
                    errorMessage = stringResource(id = R.string.invalid_email)
                )
                Spacer(modifier = Modifier.height(55.dp))
                PrimaryButton(label = stringResource(R.string.send), isEnabled = isValidEmail)
            }
        }
    }
}

@Preview()
@Composable
fun LoginPreview() {
    ComposeForgotPasswordScreen(email = "test@email.com", isValidEmail = false)
}

