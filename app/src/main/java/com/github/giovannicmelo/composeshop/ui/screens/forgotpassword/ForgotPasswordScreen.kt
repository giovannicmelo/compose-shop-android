package com.github.giovannicmelo.composeshop.ui.screens.forgotpassword

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.giovannicmelo.composeshop.R
import com.github.giovannicmelo.composeshop.ui.components.*
import com.github.giovannicmelo.composeshop.ui.theme.ComposeShopTheme

@Composable
fun ForgotPasswordScreen(
    dataState: DataState = DataState(),
    isValidEmail: Boolean? = null,
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
                    text = dataState.email,
                    onChanged = onEmailChanged,
                    isValid = isValidEmail,
                    errorMessage = stringResource(id = R.string.invalid_email)
                )
                Spacer(modifier = Modifier.height(55.dp))
                PrimaryButton(
                    label = stringResource(R.string.send),
                    isEnabled = isValidEmail == true
                )
            }
        }
    }
}

@Preview()
@Composable
fun LoginPreview() {
    ForgotPasswordScreen(dataState = DataState("test@email.com"), isValidEmail = false)
}