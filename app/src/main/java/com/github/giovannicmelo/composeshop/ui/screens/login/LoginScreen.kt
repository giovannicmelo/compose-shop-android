package com.github.giovannicmelo.composeshop.ui.screens.login

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.giovannicmelo.composeshop.R
import com.github.giovannicmelo.composeshop.ui.components.*
import com.github.giovannicmelo.composeshop.ui.theme.ComposeShopTheme
import com.github.giovannicmelo.composeshop.ui.theme.Primary
import com.github.giovannicmelo.composeshop.utils.UiState

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun LoginScreen(
    uiState: UiState<String>?,
    dataState: DataState = DataState(),
    isValidEmail: Boolean? = null,
    isValidPassword: Boolean? = null,
    onEmailChanged: (String) -> Unit = {},
    onPasswordChanged: (String) -> Unit = {},
    forgotPasswordAction: () -> Unit = {},
    successAction: () -> Unit = {},
    failureAction: (String) -> Unit = {},
    loginAction: () -> Unit = {}
) {
    ComposeShopTheme {
        Scaffold(
            topBar = { TopAppBarSimple() },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column {
                    Headline1Text(text = stringResource(R.string.title_activity_login))
                    Spacer(modifier = Modifier.height(73.dp))
                    EmailTextField(
                        text = dataState.email,
                        onChanged = onEmailChanged,
                        isValid = isValidEmail,
                        errorMessage = stringResource(R.string.invalid_email)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    PasswordTextField(
                        text = dataState.password,
                        onChanged = onPasswordChanged,
                        isValid = isValidPassword,
                        errorMessage = stringResource(R.string.invalid_password)
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = forgotPasswordAction)
                    ) {
                        DescriptiveText(text = stringResource(R.string.forgot_password))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_round_arrow_right),
                            tint = Primary,
                            contentDescription = null
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    PrimaryButton(
                        label = stringResource(R.string.login),
                        isEnabled = isValidEmail == true && isValidPassword == true && uiState !is UiState.Loading,
                        action = loginAction
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    DescriptiveText(text = stringResource(R.string.login_social_account))
                    Spacer(modifier = Modifier.height(14.dp))
                    Row {
                        GoogleSocialMediaButton()
                        Spacer(modifier = Modifier.width(16.dp))
                        FacebookSocialMediaButton()
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                }

                when (uiState) {
                    is UiState.Loading -> {
                        Loader(true)
                    }
                    is UiState.Success -> {
                        Loader(false)
                        successAction()
                    }
                    is UiState.Failure -> {
                        Loader(false)
                        failureAction(uiState.message)
                        Log.v("LoginScreen", uiState.message)
                    }
                    else -> {}
                }
            }
        }
    }
}

@Preview()
@Composable
fun LoginPreview() {
    LoginScreen(
        dataState = DataState(email = "test@email.com", password = "123456"),
        uiState = UiState.Idle
    )
}